@WebListener
public class BootInitializer implements ServletContextListener {

 // what to do startup?
 @Override
 public void contextInitialized(ServletContextEvent sce) {
    System.out.println("Starting proxy application ...");
    // your main method content here ...
 }

 // what to do shutdown?
 @Override
 public void contextDestroyed(ServletContextEvent arg0) {

 }
}