public class CoreLogger {
    public static Logger getLogger(final Class moduleName) {
        Logger logger = Logger.getLogger(moduleName);
        Properties prop = new Properties();
        try {
            prop.load(new FileReader("log4j.properties"));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        prop.put("log4j.appender.DB.user", "root");
        prop.put("log4j.appender.DB.password", "root");
        PropertyConfigurator.configure(prop);
        return logger;
    }
}