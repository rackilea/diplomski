public class MyServletContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // initialize and startup whatever you need here
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // shutdown and destroy those things here
    }
}