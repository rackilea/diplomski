public class LoggerHelper {

    private static Logger logger;

    private void injectLogger(@Observes @Initialized(ApplicationScoped.class) Object context, 
            Logger logger) {
        LoggerHelper.logger = logger;
    }

    public static Logger getLogger() {
        return logger;
    }

}