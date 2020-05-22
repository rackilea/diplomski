ThreadGroup threadGroupCompute = new ThreadGroup("compute");
threadGroupCompute.setMaxPriority(Thread.NORM_PRIORITY);
threadGroupCompute.setDaemon(false);
ThreadFactory threadFacoryCompute = new ThreadFactory() {
    long cnt = 0;
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(threadGroupCompute, r, "thread-" + threadGroupCompute.getName() + "-" + cnt++);
        return t;
    }
};
final ScheduledExecutorService executorCompute = new ScheduledThreadPoolExecutor(1, threadFacoryCompute);

// May be delayed by performance
executorCompute .scheduleAtFixedRate(new ComputeThread(), 0, 10, TimeUnit.MILLISECONDS);