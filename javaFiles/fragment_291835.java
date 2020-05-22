package com.myorg.myapp.config;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.glassfish.jersey.servlet.ServletContainer;

@WebFilter(value = "/*", initParams = @WebInitParam(name = "javax.ws.rs.Application", value = "com.myorg.myapp.config.JerseyConfig"))
public class JerseyFilter extends ServletContainer {

    private static final long serialVersionUID = 1L;

}