ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
ScheduledFuture<?> handle =
        scheduler.scheduleWithFixedDelay(new Runnable() {
             public void run() { 
                 throw new RuntimeException("foo");
             }
        }, 1, 10, TimeUnit.SECONDS);

// Create and Start an exception handler thread
// pass the "handle" object to the thread
// Inside the handler thread do :
....
try {
  handle.get();
} catch (ExecutionException e) {
  Exception rootException = e.getCause();
}