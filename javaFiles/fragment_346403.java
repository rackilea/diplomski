executorService = new ThreadPoolExecutor(
            properties.minThreads, properties.maxThreads,
            properties.maxThreadIdle, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>()
    );
    connectionFactory.setSharedExecutor(executorService);