@WebListener
public class Config implements ServletContextListener {

    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleAtFixedRate(new Task(), 0, 1, TimeUnit.MINUTES); // Schedule to run every minute.
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        scheduler.shutdown(); // Important! This stops the thread.
    }

}