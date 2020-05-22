// create java thread pool.
ExecutorService pool = Executors.newCachedThreadPool();
//initialize factory with backing pool
PoolFiberFactory fiberFactory = new PoolFiberFactory(pool);
Fiber fiber = fiberFactory.create();
fiber.start();
//use fiber for normal publishing and subscribing.