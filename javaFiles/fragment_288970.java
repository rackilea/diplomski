@WebListener
public class MyApplicationListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Put code here which should be executed on application's startup.
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // Put code here which should be executed on application's shutdown.
    }

}