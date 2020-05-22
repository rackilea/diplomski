public abstract class AbstractContinuousTask implements Runnable {

    private long maxDurationInMs = 100;
    private ExecutorService execService;

    public AbstractContinousTask(long maxDurationInMs, ExecutorService execService) {
        this.maxDurationInMs = maxDurationInMs;
        this.execService = execService;
    }

    @Override
    public final void run() {
        long start = System.currentTimeMillis();
        while (!Thread.interrupted() && (System.currentTimeMillis() - start < maxDurationInMs)) {
            runInternal();
        }
        execService.submit(this);
    }

    public abstract void runInternal();

}