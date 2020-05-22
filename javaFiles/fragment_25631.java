ThreadPoolExecutor threadPool =
   new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue()) {
     public void terminated() {
        super.terminated();
        // do something magic
     }
};
threadPool.execute(task);
// ...
// need to shutdown the pool after you've submitted all of the tasks
threadPool.shutdown();