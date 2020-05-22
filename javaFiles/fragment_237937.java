public class BootstrapLock {
    private static volatile boolean inBootstrap = true;

    public static boolean inBootstrap() {
        return inBootstrap;
    }

    public static synchronized void setEndOfBS() {
        inBootstrap = false;
    }
}

public class DummyAgent {
    public static void premain(String options, Instrumentation ins) {
        BootstrapLock.setEndOfBS();
    }
}