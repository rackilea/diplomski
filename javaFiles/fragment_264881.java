private static Logger buildLogger() {

        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        lc.reset();
        Logger logger = lc.getLogger(henson.class);
        logger.detachAndStopAllAppenders();

        PatternLayoutEncoder ple = new PatternLayoutEncoder();
        ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
        ple.setContext(lc);
        ple.start();

        ConsoleAppender<ILoggingEvent> ca = new ConsoleAppender<>();
        ca.setTarget("System.err");
        ca.setContext(lc);
        ca.setEncoder(ple);
        ca.start();

        logger.addAppender(ca);

        logger.setLevel(Level.DEBUG);
        return logger;
    }