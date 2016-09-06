package com.xc.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xc.jackson.annotation.ExtendableBean;
import com.xc.jackson.annotation.MyBean;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Administrator on 2016/9/6.
 */
public class AnnotationTest {
    @Test
    public void jsonAnyGetterTest() throws Exception {
        ExtendableBean bean = new ExtendableBean("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
        assertThat(result, containsString("attr1"));
        assertThat(result, containsString("val1"));
    }

    @Test
    public void jsonGetterTest() throws Exception {
        MyBean bean = new MyBean(1,"My Bean");

        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);

        assertThat(result,containsString("My Bean"));
        assertThat(result,containsString("1"));
    }
}
