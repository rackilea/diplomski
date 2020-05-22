package org.paulvargas.shared;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CacheListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        Map<String, String> dummyCache = new HashMap<String, String>();
        dummyCache.put("greeting", "Hello Word!");

        ServletContext context = sce.getServletContext();
        context.setAttribute("dummyCache", dummyCache);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.removeAttribute("dummyCache");
    }

}