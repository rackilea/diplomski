public class LoggerToDb implements ILogger {
    @Override
    public void logInformation(string logInfo) {
        DbContext databaseContext = new DbContext();
        databaseContext.insertLog(logInfo);
    }
}