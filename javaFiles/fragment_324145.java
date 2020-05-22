public class MyThreadPoolExecutor extends ThreadPoolExecutor {

    public MyThreadPoolExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
            BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    @Override
    public Future<?> submit(Runnable task) {
    // get the threadLocal from current thread which is task submitting thread  
        boolean threadLocalValueFromParentThread = ThreadLocalsUtils.getThreadLocalValueForThisThread.get();

        Runnable wrappedTask = () -> {
            try {
                // set value of task submitting thread's value in whichever thread gets this runnable.
                ThreadLocalsUtils.setThreadLocalValueForThisThread(threadLocalValueFromParentThread);
                task.run();
            } finally {
                ThreadLocalsUtils.setThreadLocalValueForThisThread(false);
            }
        };
        return super.submit(wrappedTask);
    }

}