ExecutorService service = Executors.newCachedThreadPool();
Future<ResultType> future = service.submit(new Callable<ResultType() {
   public ResultType call() throws Exception {
      // do soemthing
      return (ResultType) ...;
   }
);
// do anything you like until you need to result.
try {
   ResultType result = future.get(5, TimeUnit.SECONDS);
} catch (TimeoutException timedOut) {
  // handle exception
  // cancel the task, interrupting if still running.
  result.cancel(true);
} catch (ExecutionException taskThrewAnException) {
  // handle exception
}
// when you have finished with the service, which is reusable.
service.shutdown();