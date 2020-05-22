final BlockingQueue queue = new ArrayBlockingQueue<Runnable>(200);
ThreadPoolExecutor threadPool = new ThreadPoolExecutor(nThreads, nThreads,
       0L, TimeUnit.MILLISECONDS, queue);
// by default (unfortunately) the ThreadPoolExecutor will call the rejected
// handler when you submit the 201st job, to have it block you do:
threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
   public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
      // this will block if the queue is full
      executor.getQueue().put(r);
   }
});