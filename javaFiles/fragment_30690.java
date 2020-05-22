@Configuration
class ExecutorServiceConfiguration {

    @Value("${"executor.thread.count"}")
    private int executorThreadCount;


     public static class MyExecutorService {
           private ThreadPoolExecutor executor;

           public MyExecutorService(ThreadPoolExecutor executor) {
               this.executor = executor;
           }
           @PreDestroy()
           public destroy() {
                  // destroy executor
           }
     }

    @Bean("executorThreadPool")
    public ThreadPoolExecutor cachedThreadPool() {
        return new ThreadPoolExecutor(executorThreadCount, executorThreadCount, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
    }

    @Bean
    public MyExecutorService configureDestroyableBean(ThreadPoolExecutor cachedThreadPool) 
    {
      return new MyExecutorService(cachedThreadPool);
    }

}