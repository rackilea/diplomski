import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.LoggerContext;
...

public static void main(String[] args) {
    final AnnotationConfigApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class)

    Runtime.getRuntime().addShutdownHook(new Thread() {
        public void run() {
            //shutdown application
            LOG.info("Shutting down spring context");
            springContext.close();

            //shutdown log4j2
            if( LogManager.getContext() instanceof LoggerContext ) {
                logger.info("Shutting down log4j2");
                Configurator.shutdown((LoggerContext)LogManager.getContext());
            } else
                logger.warn("Unable to shutdown log4j2");
        }
    });

    //more application initialization
}