final ApplicationContext appContext = ... // create your application context 
                         // using one of the various application context classes
Runtime.getRuntime().addShutdownHook(new Thread() {
   public void run() {
       appContext.close();
   }});