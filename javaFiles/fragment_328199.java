import java.util.logging.Level;
import java.util.logging.Logger;
Logger logger = Logger.getLogger("MyCustomlogger");
logger.logp(Level.INFO, "HelloWorld", "method", "INFO level message");
logger.logp(Level.WARNING, "HelloWorld", "method", "WARNING level message");
logger.logp(Level.SEVERE, "HelloWorld", "method", "SEVERE level message");
logger.logp(Level.FINE, "HelloWorld", "method", "FINE level message");
logger.logp(Level.FINER, "HelloWorld", "method", "FINER level message");
logger.logp(Level.FINEST, "HelloWorld", "method", "FINEST level message");