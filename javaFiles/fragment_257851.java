ExecutorService executorService = Executors.newFixedThreadPool(5);

executorService.execute(new Runnable() {
  public void run() {
    // perform call};
  }
});