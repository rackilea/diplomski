public class Logger {

    /**
     * The ExecutorService runs the Thread that processes the logs.
     */
    private final ExecutorService loggingService = Executors.newSingleThreadExecutor();

    /**
     * A queue that contains the logs.
     */
    final BlockingQueue<YourLogObject> logs = new LinkedBlockingQueue<>();

    /**
     * Creates a new Logger object and starts the Thread that processes the logs.
     */
    public Logger() {
        loggingService.submit(new Runnable() {

            @Override
            public void run() {
                try {
                    for (;;) {
                        final YourLogObject log = logs.take();

                        // setData(log.getMessage());
                        // notify(log.getLevel());
                    }
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }

        });
    }

    /**
     * Creates a new YourLogObject from the given parameters and puts it at the end of the queueu.
     */
    public void writeLog(final String level, final String message) {
        final YourLogObject log = new YourLogObject(level, message);

        try {
            logs.put(log);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     */
    public void shutdown() {
        loggingService.shutdownNow();
    }

}

public class YourLogObject {

    private final String level;

    private final String message;

    public YourLogObject(final String level, final String message) {
        this.level = level;
        this.message = message;
    }

    public String getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

}