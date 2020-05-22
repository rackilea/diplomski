public class MyAppServletContextListener implements ServletContextListener{
   @Override
   public void contextInitialized(ServletContextEvent arg0) {
       YourClass x = new YourClass();
   }

   @Override
   public void contextDestroyed(ServletContextEvent arg0) {
   }
}