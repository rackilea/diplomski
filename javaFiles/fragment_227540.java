public class Logger {

    public final static String PROPERTIES_FILE = "Logger.properties";
    private static java.util.logging.Logger logger = null;

    private static void initialize() {
        try {
            logger = java.util.logging.Logger.getLogger(Logger.class.getName());
            FileHandler fh = new FileHandler("D:\\MyLogFile.log", true);
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
            logger.log(Level.INFO, "Test Message Logged");

        }
        catch (IOException e) {
          System.out.println("Warning: Unable to read properties file " +
                             PROPERTIES_FILE );
        }   
    }

    static {
        initialize();
    }

    public static java.util.logging.Logger getLogger(String name)
    {
        logger.getLogger(name);
        return logger;
    }


}