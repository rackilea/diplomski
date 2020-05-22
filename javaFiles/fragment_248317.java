public final class LogWriter
{

    private static Logger appLogger = null;

    private static String className = LogWriter.class.getName() + ".";

    static
    {
        try
        {
            appLogger = Logger.getLogger("Demologer");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void logDebug(String message)
    {
        appLogger.log(className, Level.DEBUG, LogWriter.getMessage(message), null);
    }


    public static void logInfo(String message)
    {
        appLogger.log(className, Level.INFO, LogWriter.getMessage(message), null);
    }

    public static void logError(String message)
    {
        appLogger.log(className, Level.ERROR, LogWriter.getMessage(message), null);
    }

    private static String getMessage(String message)
    {
        String retValue;

        Calendar cale = Calendar.getInstance();
        Date now = cale.getTime();

        //retValue=now.getDate()+"/"+(now.getMonth()+1)+"/"+(now.getYear()+1900)+"  "+now.getHours()+":"+now.getMinutes()+":"+now.getSeconds();
        retValue = now + "\n";

        now = null;
        cale = null;

        return retValue + message;
    }
}