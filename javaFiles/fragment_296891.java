import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.FileAppender;
import org.slf4j.LoggerFactory;

public class LoggerUtil {
  public static void main(String[] args) {
    Logger example1 = createLoggerFor("example1", "example1.log");
    Logger example2 = createLoggerFor("example2", "example2.log");
    example1.info("test-example1");
    example2.info("test-example2");
  }

  private static Logger createLoggerFor(String string, String file) {
    LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
    PatternLayoutEncoder patternLayoutEncoder = new PatternLayoutEncoder();

    patternLayoutEncoder.setPattern("%date %level [%thread] %logger{10} [%file:%line] %msg%n");
    patternLayoutEncoder.setContext(loggerContext);
    patternLayoutEncoder.start();
    FileAppender<ILoggingEvent> fileAppender = new FileAppender<ILoggingEvent>();
    fileAppender.setFile(file);
    fileAppender.setEncoder(patternLayoutEncoder);
    fileAppender.setContext(loggerContext);
    fileAppender.start();

    Logger logger = (Logger) LoggerFactory.getLogger(string);
    logger.addAppender(fileAppender);
    logger.setLevel(Level.DEBUG);
    logger.setAdditive(false); /* set to true if root should log too */

    return logger;
  }
}