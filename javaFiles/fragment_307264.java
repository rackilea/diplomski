public class SynchronizedLogger {

//Logger to put error logs and messages in the log file

public static Logger logger = Logger.getLogger("MyLog");


//Logger Filehandler
private static FileHandler loggerFH;

public SynchronizedLogger() {
}

public static synchronized void writeLog(String message) {
    logger.info(message);
}

public SynchronizedLogger(int i) {
    try {
        synchronized (this) {
            // This block configures the logger with handler and formatter
            loggerFH = new FileHandler(System.getProperty("user.dir") + "\\resources\\logs\\logs.txt", 0, 1, true);
            logger.setUseParentHandlers(false);
            logger.addHandler(loggerFH);

            SimpleFormatter formatter = new SimpleFormatter();
            loggerFH.setFormatter(formatter);
        }

    } catch (IOException | SecurityException ex) {
        writeLog(ex.getMessage());
        outputArea.append("\n\n" + ex.getMessage());

    }
}