ExecutorService threadPool = Executors.newSingleThreadScheduledExecutor();
Future<Void> future = threadPool.submit(new Callable<Void>() {
      public Void call() throws Exception {
         // can throw OhNoException here
         return null;
     }
});
// you need to shut down the pool after submitting the last task
threadPool.shutdown();
// this can throw ExecutionException
try {
   // this waits for your background task to finish, it throws if the task threw
   future.get();
} catch (ExecutionException e) {
    // this is the exception thrown by the call() which could be a OhNoException
    Throwable cause = e.getCause();
     if (cause instanceof OhNoException) {
        throw (OhNoException)cause;
     } else if (cause instanceof RuntimeException) {
        throw (RuntimeException)cause;
     }
}