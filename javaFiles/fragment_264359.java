ExecutorService service = Executors.newFixedThreadPool(5);
StoppableExecutor executor = new StoppableExecutor(service);

// doing some actor stuff with executor instance
PoolFiberFactory factory = new PoolFiberFactory(executor);

// stopping tasks only created on executor instance
// executor service is happily running other tasks
executor.stop();