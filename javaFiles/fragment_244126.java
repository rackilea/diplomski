package com.platypus;

import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;


@RunWith(JMockit.class)
public class ServletActionContextTest
{

    @Tested
    private QueryAction queryAction;

    @Mocked
    private HttpServletRequest httpServletRequest;
    @Mocked
    private ServletActionContext servletActionContext;

    @Test
    public void test()
            throws Exception
    {
        new Expectations(){{
            ServletActionContext.getRequest(); result = httpServletRequest;
            httpServletRequest.getParameter("paramJson"); result = "foo";
        }};

        String queryInfo = queryAction.queryInfo();

        assertEquals("foo", queryInfo);
    }
}