public class LocalLogger {

  private final Logger logger;

  public LocalLogger(String name) {
    logger = Logger.getLogger(name);
  }

  public LocalLogger(@SuppressWarnings("rawtypes") Class clazz) {
    logger = Logger.getLogger(clazz);
  }

  public void antiqueLoggingMethod(String msg) {
    logger.info(msg);
  }

  // etc.
}