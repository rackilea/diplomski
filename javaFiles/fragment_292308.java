@Bean(destroyMethod="shutdown")
public ListeningExecutorService listeningExecutorService() {
    ThreadFactory threadFactory = new ThreadFactoryBuilder()
        .setNameFormat(" Listening Executor Service [%d]").build();
    ExecutorService executorService = Executors.newScheduledThreadPool(
            SOMECONSTANT.TASK_EXECUTOR_THREADS, threadFactory);
    return MoreExecutors.listeningDecorator(executorService);
}