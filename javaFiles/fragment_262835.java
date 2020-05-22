public static void main(String[] args) {
    ctx = SpringApplication.run(MyApp.class, args);

    final LoggerContext context = (LoggerContext) LogManager.getContext(false);
    final Configuration config = context.getConfiguration();
    LoggerConfig loggerConfig = config.getLoggerConfig("loggerName");
    loggerConfig.removeAppender("CONSOLE");
    context.updateLoggers();
}