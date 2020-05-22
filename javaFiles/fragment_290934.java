package com.tugay.listeners;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

public class ServletContextListenerForDataSource
        implements ServletContextListener {

    @Resource(name = "jdbc/superblog")
    DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        servletContextEvent.getServletContext().setAttribute("datasource", dataSource);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}