static class LoggerHolder {
  static Logger logger = Logger.getLogger(MyClass.class);
}

private static Logger getLogger() {
  return LoggerHolder.logger;
}