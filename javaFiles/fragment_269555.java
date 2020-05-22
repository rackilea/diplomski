public class ThreadData {
    public static final ThreadLocal<String> data = new ThreadLocal<String>();
}

public class InitializingThread extends Thread {
    public InitializingThread(Runnable r) {
        super(r);
    }

    public void run() {
        ThreadData.data.set("foo");
        super.run();
    }
}

public class InitializingThreadFactory implements ThreadFactory {
    public Thread newThread(Runnable r) {
        return new InitializingThread(r);
    }
}

ThreadPoolExecutor executor = ...;
executor.setThreadFactory(new InitializingThreadFactory());
executor.execute(...);