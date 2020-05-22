// set a handler that just calls back to the queue which will block the submitter
threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
   public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
      // this will block if the queue is full
      executor.getQueue().put(r);
   }
});