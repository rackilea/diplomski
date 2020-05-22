protected void setupLogger(String fileName) {

        try {
            SimpleLayout layout = new SimpleLayout();
            FileAppender appender;
            appender = new FileAppender(layout, DIRECTORY + "/logs/" +        fileName + EXTENSION, false); 
            logger.addAppender(appender);
            logger.setLevel((Level) Level.DEBUG);
        } catch (IOException e) { 
            e.printStackTrace();
        }
    }