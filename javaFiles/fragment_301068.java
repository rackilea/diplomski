//Install the JUL Bridge
SLF4JBridgeHandler.removeHandlersForRootLogger();
SLF4JBridgeHandler.install();

//Obtain an instance of LoggerContext
LoggerContext context = (LoggerContext)LoggerFactory.getILoggerFactory();

//Create a new FileAppender
FileAppender<ILoggingEvent> file = new FileAppender<ILoggingEvent>();
file.setName("FileLogger");
file.setFile("error.log");
file.setContext(context);
file.setAppend(true);

//Filter out anything < WARN
ThresholdFilter warningFilter = new ThresholdFilter();
warningFilter.setLevel("WARN");
warningFilter.setContext(context);
warningFilter.start();
file.addFilter(warningFilter);

//Message Encoder
PatternLayoutEncoder ple = new PatternLayoutEncoder();
ple.setContext(context);
ple.setPattern("%date %level [%thread] %logger{10} %msg%n");
ple.start();
file.setEncoder(ple);

file.start();

//Get ROOT logger, and add appender to it
Logger root = context.getLogger(Logger.ROOT_LOGGER_NAME);
root.setLevel(Level.DEBUG);
root.addAppender(file);