import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.rolling.RollingFileAppender;
import org.slf4j.LoggerFactory;

public class Main {
  public static void main(String[] args) {
    Logger logger = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
    RollingFileAppender appender=(RollingFileAppender)logger.getAppender("DateRollingFileAppender");
    System.out.println(appender.getRollingPolicy().getActiveFileName());
  }
}