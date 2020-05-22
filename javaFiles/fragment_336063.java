package com.example;

import javax.servlet.http.HttpServletRequestWrapper;

public class MyHttpServletRequest extends HttpServletRequestWrapper {

    public MyHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    public String getParameter(String name) {
        String str = super.getParameter(name);
        // DO THE REWRITING
        return str;
    }