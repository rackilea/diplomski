public class ZRToolLogger{

public static FileHandler fh;
public static Logger getInfoLogger(String loggerName)
{
    LogManager logManager = LogManager.getLogManager();
    Logger logger = Logger.getLogger(loggerName);
    logger.setUseParentHandlers(false);

    if (ZRToolLogger.fh = null)
    {
        try{
            ZRToolLogger.fh = new FileHandler(ZRToolConstants.CTX_PATH+"/logs/log.%u.txt", true);
        }
        catch(IOException e)
        {
        }
    }
    logManager.addLogger(logger);
    ZRToolLogFormatter formatterTxt = new ZRToolLogFormatter();

    if(ZRToolLogger.fh != null)
    {
        ZRToolLogger.fh.setFormatter(formatterTxt);
    }
    logger.addHandler(fh);

    return logger;
}

private static class ZRToolLogFormatter extends Formatter
{
    public ZRToolLogFormatter()
    {
        super();
    }

    @Override
    public String format(LogRecord log)
    {
        return log.getLevel() + ":" + formatMessage(log)+"\n";
    }
}