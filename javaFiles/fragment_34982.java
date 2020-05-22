class MyMainClass {
  private static final ExecutorService es = Executors.newFixedThreadPool(10);
  public static void main(String... args) {
    es.submit(new MyRunnable());
    es.submit(new MyRunnable());
    es.submit(new MyRunnable());
    es.submit(new MyRunnable());
    es.submit(new MyRunnable());
  }
}