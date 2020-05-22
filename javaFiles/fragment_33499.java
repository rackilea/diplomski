public class LoggingConfigurationApplicationListener implements GenericApplicationListener {
    private static final Logger logger = LoggerFactory.getLogger(LoggingConfigurer.class);

    private boolean addedCustomAppender;

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (!addedCustomAppender && metricProperties.isEnabled()) {
            ApplicationPreparedEvent applicationEvent = (ApplicationPreparedEvent) event;
            EventsPublisher eventPublisher = applicationEvent.getApplicationContext().getBean(EventsPublisher.class);
            //Add log appender for Monitoring
            final Appender<ILoggingEvent> newAppender = new CustomLogbackAppender(eventPublisher);
            LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
            final ch.qos.logback.classic.Logger root = context.getLogger("ROOT");
            newAppender.setName("Custom Appender");
            newAppender.setContext(context);
            newAppender.start();
            root.addAppender(newAppender);
            logger.info("Added custom log appender");
            addedCustomAppender = true;
        }
    }

    @Override
    public int getOrder() {
        // this must be higher than LoggingApplicationListener.DEFAULT_ORDER
        return Ordered.HIGHEST_PRECEDENCE + 21;
    }

    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        // this is the earliest 'event type' which is capable of exposing the application context
        return ApplicationPreparedEvent.class.isAssignableFrom(eventType.getRawClass());
    }

    @Override
    public boolean supportsSourceType(Class<?> sourceType) {
        return true;
    }
}