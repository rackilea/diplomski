public final class AppLogger {

    private Logger logger;       

    protected AppLogger(String  loggerName) {
         this.logger = LoggerFactory.getLogger(loggerName);
    }

    public static AppLogger getAppLogger(String loggerName) {
         return new AppLogger(loggerName);
    }

    public void info(String... args) {
        this.logger.info(LogsUtils.generateLogString(args));
    }
    ...
}