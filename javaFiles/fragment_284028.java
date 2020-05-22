@Override
public void contextInitialized(ServletContextEvent event) {
    try {
      super.contextInitialized(event);
    } catch (Throwable T) {
      T.printStackTrace();
      System.exit(1);
    }
}