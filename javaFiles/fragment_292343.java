public static void main() {
  final ExecutorService es = Executors.newCachedThreadPool();
  final Future<Boolean> f = es.submit(new myClass());
  try {
    System.out.println("The result is: " + f.get());
  } catch (ExecutionException e) {
    System.err.println("A method executed on the background thread has thrown an exception");
    e.getCause().printStackTrack();
  }
  es.shutdown();
}