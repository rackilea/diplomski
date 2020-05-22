// create a thread pool with 10 workers
ExecutorService threadPool = Executors.newFixedThreadPool(10);
// or you can create an open-ended thread pool
// ExecutorService threadPool = Executors.newCachedThreadPool();
while (recursing) {
    threadPool.submit(new MyRunnable(myObject));
}
// once we have submitted all jobs to the thread pool, it should be shutdown
threadPool.shutdown();
...