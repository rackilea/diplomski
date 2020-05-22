public class LoggingFactory {
    private static LoggingFactory instance;
    private Map<Class, Logger> loggers;

    public static synchronized LoggingFactory getInstance() {
        if(instance == null) {
            instance = new LoggingFactory();
        }
        return instance;
    }

    public static Logger getLogger(Class clazz) {
        synchronized (clazz) {
            if(getInstance().loggers.get(clazz) == null) {
                getInstance().loggers.put(clazz, Logger.getLogger(clazz.getName()));
            }
            return getInstance().loggers.get(clazz);
        }
    }
}