public class App 
{
    static final Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args )
    {
        PropertyConfigurator.configure("/absolute/path/to/log4j.properties");
        logger.debug("Hello world!");
    }
}