// only allow 10 concurrent requests
ExecutorService threadPool = Executors.newFixedThreadPool(10);
...
while (requestsComeIn) {
    threadPool.submit(yourRunnableRequest);
}
// you need to shut the pool down once no more requests come in
threadPool.shutdown();