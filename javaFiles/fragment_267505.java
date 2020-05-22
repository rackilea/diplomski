BlockingQueue<String> hugeQueue = ...
ExecutorService executor = Executors.newFixedThreadPool(5);
LongRunningWorker longRunningWorker = new LongRunningWorker(hugeQueue);
for( int i = 0; i < 5 ; i++ ) {
    executor.submit(longRunningWorker)
}