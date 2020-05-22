public class MyServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
    //Notification that the servlet context is about to be shut down.   
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
    // do all the tasks that you need to perform just after the server starts

    //Notification that the web application initialization process is starting
    }

}