package com.application.my;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public final class TestServletFilter implements Filter {

    @Override
    public void init(FilterConfig config) { }

    @Override
    public void doFilter(
            final ServletRequest request,
            final ServletResponse response,
            final FilterChain chain
    ) throws IOException, ServletException {
        System.out.println("calling getParameter on " + request.getClass().getName());
        request.getParameter("blah");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() { }
}