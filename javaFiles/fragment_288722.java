import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.FileAppender;
import org.apache.logging.log4j.core.config.Configuration;

...

LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
Configuration config = ctx.getConfiguration();
FileAppender techical = (FileAppender) config.getAppender("Technical");
File dir = new File(techical.getFileName().replaceFirst("[^\\/]+$", ""));