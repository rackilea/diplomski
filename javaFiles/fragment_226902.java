import java.util.logging.*;

public aspect SwingExceptionLogger {
    static Logger logger = Logger.getLogger(SwingExceptionLogger.class.getName());

    Object around() : execution(* MinimalSwingApplication..*(..)) {
        try {
            return proceed();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Swing exception: " + e.getMessage());
            return null;
        }
    }
}