class Log {

  private static MyLogger logger;

  static {
    String className = System.getProperty("my.static.logger.class.name");
    // Instantiate your logger here...
    // By default use some DefaultLogger implementation...
  }

  public static void error(String message, Throwable t) {
    logger.error(message, t);
  }

}