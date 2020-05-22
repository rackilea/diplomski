ExecutorService pool = Executors.newFixedThreadPool(10);
Future<Void> future = pool.submit(new Callable<Void>() {
    public Void call() throws Exception {
       // your agent code goes here
       // this can throw an exception in this block which will be re-thrown below
       return null;
    }
});
...
try {
   // then the exception will be thrown here for you to catch and log
   future.get();
} catch (ExecutionException e) {
   // log the e.getCause() here
}
...
pool.shutdown();