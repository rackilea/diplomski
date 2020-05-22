Logger cmRootLogger = Logger.getLogger("default.config");
  cmRootLogger.setLevel(java.util.logging.Level.OFF);
  String conFile = System.getProperty("java.util.logging.config.file");
  if (conFile == null) {
        System.setProperty("java.util.logging.config.file", "ignoreAllSphinx4LoggingOutput");
  }