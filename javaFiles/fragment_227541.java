public class Logger {

    // note: volatile is required
    private volatile static java.util.logging.Logger logger = null;

    //... 

    public static java.util.logging.Logger getLogger(String name)
    {
        if(logger==null)
        {
           synchronized(Logger.class) 
           {
              if(logger == null)
                Logger.initialize();
              }
           }
        }
        logger.getLogger(name);
        return logger;
    }
}