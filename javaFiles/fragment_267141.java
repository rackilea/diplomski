final org.slf4j.Logger logger = 
    org.slf4j.LoggerFactory.getLogger("test.package");
if (!(logger instanceof ch.qos.logback.classic.Logger)) {
    return;
}
ch.qos.logback.classic.Logger logbackLogger = 
    (ch.qos.logback.classic.Logger) logger;
logbackLogger.setLevel(ch.qos.logback.classic.Level.TRACE);
logger.trace("some log");