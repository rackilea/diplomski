import java.util.logging.Level;
import java.util.logging.Logger;

[...]

Logger logger = Logger.getAnonymousLogger();
Exception e1 = new Exception();
Exception e2 = new Exception(e1);
logger.log(Level.SEVERE, "an exception was thrown", e2);