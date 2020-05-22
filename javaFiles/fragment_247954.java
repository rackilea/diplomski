private final ExecutorService service = Executors.newSingleThreadExecutor();

service.submit(new Runnable() {
   public void run() {
       // task to perform here.
   }
});