public class JobExecutor implements Executor {
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT + 1;
    private final java.util.concurrent.ExecutorService mThreadPoolExecutor;
    private final DiskDataSource mDiskDataSource;

    public JobExecutor(DiskDataSource diskDataSource) {
        mDiskDataSource = diskDataSource;
        mThreadPoolExecutor = Executors.newFixedThreadPool(CORE_POOL_SIZE, new JobThreadFactory());
    }

    @Override
    public void execute(@NonNull Runnable runnable) {
        mThreadPoolExecutor.execute(new RealmRunnable(mDiskDataSource, runnable));
    }

    private static class JobThreadFactory implements ThreadFactory {
        private static final String THREAD_NAME = "android_";
        private int counter = 0;
        @Override
        public Thread newThread(@NonNull Runnable runnable) {
            return new Thread(runnable, THREAD_NAME + counter++);
        }
    }
}