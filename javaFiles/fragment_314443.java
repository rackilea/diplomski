LayoutWrappingEncoder<ILoggingEvent> layoutEncoder = new LayoutWrappingEncoder<>();
        DropwizardLayout formatter = new DropwizardLayout(loggerContext, TimeZone.getDefault());
        formatter.setPattern("[%level] [%h] %d{yyyy-MM-dd'T'HH:mm:ss.SSS'Z', UTC} [%thread] [%logger] %msg%n");
        layoutEncoder.setLayout(formatter);
        formatter.start();
        rollingFileAppender.setEncoder(layoutEncoder);