@Component
public class MaskLoggerFactory {
    private final Appender<ILoggingEvent> appender;

    public MaskLoggerFactory(Appender<ILoggingEvent> appender) {
        this.appender = appender;
    }

    public org.slf4j.Logger getLogger(String name) {
        Logger logger = (Logger) LoggerFactory.getLogger(name);
        logger.addAppender(appender);
        logger.setLevel(Level.ALL);
        logger.setAdditive(false);
        return logger;
    }

    public org.slf4j.Logger getLogger(Class<?> cls) {
        return getLogger(cls.getName());
    }
}