@Override
protected WebApplicationContext initWebApplicationContext() throws BeansException {
    try {
      super.initWebApplicationContext();
    } catch (Throwable T) {
      T.printStackTrace();
      System.exit(1);
    }
}