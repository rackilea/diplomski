public static void initLogFile(String path, Level level){

    final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
    final Configuration config = ctx.getConfiguration();

    Layout layout = PatternLayout.createLayout(Constants.LOG_PATTERN, null, config, null, null, false, false, null, null);
    Appender appender = FileAppender.createAppender(path, "true", "true", "File", "true",
        "false", "false", null, layout, null, "false", null, config);
    appender.start();
    config.addAppender(appender);
    AppenderRef ref = AppenderRef.createAppenderRef("File", null, null);
    AppenderRef[] refs = new AppenderRef[] {ref};
    LoggerConfig loggerConfig = config.getLoggerConfig("com.jorge.myapp.business");
    loggerConfig.addAppender(appender, null, null);
    ctx.updateLoggers();
}