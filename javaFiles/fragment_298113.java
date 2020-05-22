// "Low level Module" Mechanism equivilant
public class Logger {
    public void logInformation(String logInfo) {
        System.out.println(logInfo);
    }
}

// "High level module" Policy equivalent.
public class Foo {
    // direct dependency of a low level module.
    private Logger logger = new Logger();

    public void doStuff() {
        logger.logInformation("Something important.");
    }
}