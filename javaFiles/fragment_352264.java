@Bean
public LoggerContext loggerContext() {
    return (LoggerContext) LoggerFactory.getILoggerFactory();
}

@Bean
public MaskPatternLayout maskPatternLayout(LoggerContext context) {
    MaskPatternLayout layout = new MaskPatternLayout();
    layout.setPatternsProperty("(SSN)");
    layout.setPattern("%d [%thread] %-5level %logger{35} - %msg%n");
    layout.setContext(context);
    layout.start();
    return layout;
}

@Bean
public LayoutWrappingEncoder<ILoggingEvent> maskEncoder(MaskPatternLayout layout) {
    LayoutWrappingEncoder<ILoggingEvent> encoder = new LayoutWrappingEncoder<>();
    encoder.setLayout(layout);
    return encoder;
}

@Bean
public ConsoleAppender<ILoggingEvent> maskConsoleAppender(LoggerContext context, LayoutWrappingEncoder<ILoggingEvent> maskEncoder) {
    ConsoleAppender<ILoggingEvent> appender = new ConsoleAppender<>();
    appender.setContext(context);
    appender.setEncoder(maskEncoder);
    appender.start();
    return appender;
}