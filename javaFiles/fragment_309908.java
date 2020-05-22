public final class YourListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        //Calculation goes here
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        //Nothing to do
    }
}