@Bean(destroyMethod = "shutdown")
public Executor pixTaskScheduler() {
    final ScheduledThreadPoolExecutor ex = new ScheduledThreadPoolExecutor(schedulerPoolSize, pixExecutor());
    // ex.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
    return ex;
}

@Bean
public Executor pixExecutor() {
    final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(executorMaxPoolSize);
    executor.setQueueCapacity(executorQueueCapacity);
    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
    executor.setWaitForTasksToCompleteOnShutdown(true);
    return executor;
}