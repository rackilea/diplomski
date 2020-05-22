public interface ILogger {
    void logInformation(String logInfo);
}

public class Logger implements ILogger {
    @Override
    public void logInformation(string logInfo) {
        System.out.println(logInfo);
    }
}

public class Foo {
    private ILogger logger;
    public void setLoggerImpl(ILogger loggerImpl) {
        this.logger = loggerImpl;
    }

    public void doStuff() {
        logger.logInformation("Something important.");
    }
}