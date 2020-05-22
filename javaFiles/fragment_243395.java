public class SecurityProviderInitializer implements ServletContextListener {

   @Override
   public void contextInitialized(ServletContextEvent event) {
       if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) == null) {
           Security.addProvider(new BouncyCastleProvider());
       } 
   }

   @Override
   public void contextDestroyed(ServletContextEvent event) {}
}