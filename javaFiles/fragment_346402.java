executorService = new ThreadPoolExecutor(
            properties.minThreads, properties.maxThreads,
            properties.maxThreadIdle, TimeUnit.SECONDS,
            new SynchronousQueue<>()
    );
    connectionFactory.setSharedExecutor(executorService);