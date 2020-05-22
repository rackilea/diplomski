import org.slf4j.LoggerFactory;

public class main {

public static void main(String[] args) {

   System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "Info");
   final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(LogTest.class);

   LOGGER.info("--- show this everytime");
   if(LOGGER.isDebugEnabled()) {
        LOGGER.debug("--- show this only if debug is enable");
   }

   LOGGER.info("--- show this everytime");
}