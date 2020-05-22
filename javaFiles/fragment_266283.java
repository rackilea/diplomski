ExecutorService executorService =
    new ThreadPoolExecutor(
        maxThreads, // core thread pool size
        maxThreads, // maximum thread pool size
        1, // time to wait before resizing pool
        TimeUnit.MINUTES, 
        new ArrayBlockingQueue<Runnable>(maxThreads, true),
        new ThreadPoolExecutor.CallerRunsPolicy());

ConcurrentLinkedQueue<ResultObject> resultQueue;

while (iterator.hasNext()) {
    executorService.execute(new MyJob(iterator.next(), resultQueue))
}