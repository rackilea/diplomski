public class ReentrantLockZero {
    private static ReentrantLock CountLock = new ReentrantLock();
    private static int synchronisedCount = 0;
    private static int lockedCount = 0;
    private static final int RESULT_COUNT = 10_000;

    public static void main(String... args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = getMyCachedThreadPool();
        for (int i = 0; i < RESULT_COUNT; ++i) {
            threadPoolExecutor.submit(ReentrantLockZero::getSynchronisedCount);
            threadPoolExecutor.submit(ReentrantLockZero::getCountUsingLock);
        }
        threadPoolExecutor.shutdown();
        threadPoolExecutor.awaitTermination(10, TimeUnit.SECONDS);
        assert synchronisedCount == RESULT_COUNT;
        assert lockedCount == RESULT_COUNT;
    }

    private static synchronized int getSynchronisedCount() {
        synchronisedCount++;
        System.out.println(Thread.currentThread().getName() + " counting in synchronized: " + synchronisedCount);
        return synchronisedCount;
    }

    private static int getCountUsingLock() {
        CountLock.lock();
        try {
            lockedCount++;
            System.out.println(Thread.currentThread().getName() + " counting in lock: " + lockedCount);
            return lockedCount;
        } finally {
            CountLock.unlock();
        }
    }
}