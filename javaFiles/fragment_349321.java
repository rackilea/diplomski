import org.apache.logging.log4j.core.LoggerContext;

LoggerContext lc = (LoggerContext)LogManager.getContext(false);
Appender app = lc.getAppender("RollingFile");
if (app instanceof RollingFileAppender) {
    ((RollingFileAppender)app).getManager().rollover();
}