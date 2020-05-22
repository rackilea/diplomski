package loggingsscce;

import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingSSCCE {
    private static String LOG_FILE_NAME = "loggingsscce.log";
    Hashtable<String, Logger> loggers = new Hastable<String, Logger>();
    FileHandler handler = null;

    public static void main(String[] args) throws IOException {

        LogTest lta = new LogTestA();
        lta.doLog();

        LogTest ltb = new LogTestB();
        ltb.doLog();
    }

    public static Logger getLogger(String loggerName) throws IOException {
        if ( loggers.get(loggerName) != null )
            return loggers.get(loggerName);

        if ( handler == null ) {
            boolean append = true;
            handler = new FileHandler(LoggingSSCCE.LOG_FILE_NAME, append);
            handler.setFormatter(new SimpleFormatter());
        }

        Logger logger = Logger.getLogger(loggerName);
        logger.setLevel(Level.ALL);
        logger.addHandler(handler);
        loggers.put(loggerName, logger);
        return logger;
    }
}