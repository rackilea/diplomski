BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);
ThreadPoolExecutor threadPool =
      new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, queue);
// we need our RejectedExecutionHandler to block if the queue is full
threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
       @Override
       public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
           try {
                // this will block the producer until there's room in the queue
                executor.getQueue().put(r);
           } catch (InterruptedException e) {
                throw new RejectedExecutionException(
                   "Unexpected InterruptedException", e);
           }
    }
});