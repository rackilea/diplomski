import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.RollingFileAppender;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class TestMethodLogging extends TestWatcher {
  private static final String date = new SimpleDateFormat("y-MM-dd")
      .format(new Date());
  private Logger logger;

  @Override
  protected void starting(Description description) {
    String name = description.getMethodName();
    RollingFileAppender a = (RollingFileAppender) Logger.getRootLogger()
        .getAppender("rollingFile");
    PatternLayout layout = new PatternLayout();
    layout.setConversionPattern("%d{dd MMM yyyy HH:mm:ss} %p %t %c - %m%n");

    try {
      File logDir = new File(a.getFile()).getParentFile();
      File logFile = new File(logDir, name + "_" + date);
      logger = Logger.getLogger(name);
      logger.addAppender(new RollingFileAppender(layout, logFile
          .getAbsolutePath()));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  public Logger getLogger() {
    return logger;
  }
}