public class NotificationPool extends ThreadPoolExecutorFactoryBean {
     @Override
     protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
          return new PriorityBlockingQueue<>(queueCapacity);
     }

     @Override
     protected ThreadPoolExecutor createExecutor(int corePoolSize, int maxPoolSize, int keepAliveSeconds, BlockingQueue<Runnable> queue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        return new YourCustomThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveSeconds, TimeUnit.SECONDS, queue, threadFactory, rejectedExecutionHandler);
     }
}