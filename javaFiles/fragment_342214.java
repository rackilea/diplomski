// "Singleton" with replaceable instance
public class ShutdownHandler {
    private static ShutdownHandler instance = new ShutdownHandler();

    public static ShutdownHandler getInstance() {
        return instance;
    }

    public synchronized void shutdown() {
        // default implementation
        System.exit();
    }

    public static void setInstance(ShutdownHandler newInstance) {
        // (probably also check that this is only called in a test environment)
        instance = newInstance;
    }
}