public void testThreads() {
  ExecutorService threadPool = Executors.newFixedThreadPool(4);
  List<Future<?>> tasks = new LinkedList<>();
  for (int i = 0; i < 10; i++) {
    tasks.add(threadPool.submit(new MyThread()));
  }
  /*
   * no need to wait on each future- just call shutdown(),
   * the executor will run all pending tasks
   * and will then stop its worker threads
   */
  threadPool.shutdown();
}