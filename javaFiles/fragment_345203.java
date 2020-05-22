@Bean(destroyMethod = "shutdownNow", name = "MyExecutorService")
public ThreadPoolExecutor executor() {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 100, 60L,
            TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(1000), 
            new ThreadPoolExecutor.CallerRunsPolicy());
    return threadPoolExecutor;
}