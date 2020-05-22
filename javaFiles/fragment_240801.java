package com.y;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class ContextListener implements ServletContextListener {
    private static ServletContext servletContext;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        servletContext = arg0.getServletContext();
    }

    public static ServletContext getServletContext(){
        return servletContext;
    }
}