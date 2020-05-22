LogManager.resetConfiguration();

    PatternLayout layout = new PatternLayout();
    layout.setConversionPattern("RECORD-BACKEND / (%-5p) %m (%F:%L)%n");

    ConsoleAppender stderr = new ConsoleAppender(); 
    stderr.setTarget(ConsoleAppender.SYSTEM_ERR);
    stderr.setLayout(layout);
    stderr.addFilter(new CurrentThreadLogFilter());
    stderr.setThreshold(Level.INFO);
    stderr.activateOptions();

    Logger loggerRECORD = getLoggerRECORD();
    loggerRECORD.setLevel( /* get Log Level from env. */ );
    loggerRECORD.setAdditivity(false);
    loggerRECORD.addAppender(stderr);

    Logger root = Logger.getRootLogger();
    root.setLevel(Level.WARN);
    root.addAppender(stderr);

    // some lines forward ...

    loggerRECORD.info("Process starting...");