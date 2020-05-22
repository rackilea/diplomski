@WebListener("daemon_dude")
public class daemon_dude implements ServletContextListener{
...
private ScheduledExecutorService scheduler;//or whatever type of pool
public void contextInitialized(ServletContextEvent event) {
  scheduler = Executors.newSingleThreadScheduledExecutor();//and use it
}
public void contextDestroyed(ServletContextEvent event){
  scheduler.shutdownNow();//or any more peaceful approach
}
...
}