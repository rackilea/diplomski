int corePoolSize = 0;
    int maximumPoolSize = 64;
    int keepAliveTime = 5000;
    ExecutorService executorService =
            new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
                    TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());