public static void main(String args[]) {
    int numberOfThreads = 2;
    ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);
    Runnable task1 = () -> {
      System.out.println("Executing Task1 inside : " + 
      Thread.currentThread().getName());
      try {
        TimeUnit.SECONDS.sleep(2);
      } catch (InterruptedException ex) {
        throw new IllegalStateException(ex);
      }
    };
    executorService.submit(task1);
    executorService.submit(task1);
}