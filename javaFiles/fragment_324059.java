SiftingAppender siftAppender = new SiftingAppender();

    AppenderFactory<ILoggingEvent> appenderFactory = new AppenderFactory<ILoggingEvent>() {

        @Override
        public Appender<ILoggingEvent> buildAppender(Context context, String discriminatingValue) throws JoranException {
            /* Create your file appender here, with what ever options you need */

            PatternLayoutEncoder ple = new PatternLayoutEncoder();
            ple.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
            ple.setContext(context);
            ple.start();
            FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
            fileAppender.setFile(file);
            fileAppender.setEncoder(ple);
            fileAppender.setContext(context);
            fileAppender.start();

            return fileAppender;
        }
    };

    /* set your factory to the sifting appender */
    siftAppender.setAppenderFactory(appenderFactory );
    siftAppender.setContext(context);
    siftAppender.setName("TMP");
    siftAppender.start();

    logger.addAppender(siftAppender);
    logger.setAdditive(true);