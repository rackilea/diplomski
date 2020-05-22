import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.jboss.logmanager.LogContext;
public class MyLogger {

    private static final ThreadLocal<MyLogger> LOCAL_LOGGER = new ThreadLocal<MyLogger>();

    private final Logger logger;

    private MyLogger(final Logger logger) {
        this.logger = logger;
    }

    public static MyLogger createMyLogger(final String filename) {
        MyLogger result = LOCAL_LOGGER.get();
        if (result == null) {
            final LogContext logContext = LogContext.create();
            final Logger logger = logContext.getLogger(MyLogger.class.getName());
            final FileHandler fileHandler;
            try {
                final File loggerFile = new File(filename);
                if (loggerFile.exists()) {
                    loggerFile.delete();
                    File lockFile = new File(filename + ".lck");
                    if (lockFile.exists())
                        lockFile.delete();
                }
                fileHandler = new FileHandler(filename, true);

            } catch (IOException e) {
                throw new RuntimeException("Could not create file handler", e);
            }
            logger.addHandler(fileHandler);
            fileHandler.setFormatter(new SimpleFormatter());
            final MyLogger myLogger = new MyLogger(logger);
            LOCAL_LOGGER.set(myLogger);
            result = myLogger;
        }
        return result;
    }

    public void log(String msg) {
        logger.log(Level.INFO, msg);
    }

    public void log(Exception ex) {
        logger.log(Level.SEVERE, "Exception", ex);
    }
}