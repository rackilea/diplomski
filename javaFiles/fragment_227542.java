private volatile static java.util.logging.Logger logger = null;
private static void initialize() {
    try {
        Logger logger = java.util.logging.Logger.getLogger(Logger.class.getName());
        FileHandler fh = new FileHandler("D:\\MyLogFile.log", true);
        logger.addHandler(fh);
        logger.setLevel(Level.ALL);
        SimpleFormatter formatter = new SimpleFormatter();
        fh.setFormatter(formatter);
        logger.log(Level.INFO, "Test Message Logged");

        Logger.logger = logger;
    }
    catch (IOException e) {
      System.out.println("Warning: Unable to read properties file " +
                         PROPERTIES_FILE );
    }   

    public static java.util.logging.Logger getLogger(String name)
    {
        if(logger==null)
        {
        Logger.initialize();
        }
        logger.getLogger(name);
        return logger;
    }
}