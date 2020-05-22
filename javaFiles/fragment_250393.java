private static Properties loggerProperties = LoggerClassName.read(“log4j.properties”);

static Logger validation =
Logger.getLogger(LoggerClassName.class);

static {
  PropertyConfigurator.configure(loggerProperties);
  validation.setLevel(Level.DEBUG);
}