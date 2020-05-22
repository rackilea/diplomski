import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    static {
        // must be called before any Logger method is used.
        System.setProperty("java.util.logging.manager", MyLogManager.class.getName());
    }

    public static class MyLogManager extends LogManager {
        static MyLogManager instance;
        public MyLogManager() { instance = this; }
        @Override public void reset() { /* don't reset yet. */ }
        private void reset0() { super.reset(); }
        public static void resetFinally() { instance.reset0(); }
    }

    public static void main(String... args) {
        Logger logger1 = Logger.getLogger("Main1");
        logger1.info("Before shutdown");
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Logger logger2 = Logger.getLogger("Main2");
                    logger2.info("Shutting down 2");

                } finally {
                    MyLogManager.resetFinally();
                }
            }
        }));
    }
}