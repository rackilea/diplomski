Future<Integer> future = executor.submit(new Callable<Integer>(){
    public Integer call() throws Exception {
       return 10;
    }
});
try {
   // get() waits for the job to finish before returning the value
   // it also might throw an exception if your call() threw
   Integer i = future.get();
   ...
} catch (ExecutionException e) {
   // this cause exception is the one thrown by the call() method
   Exception cause = e.getCause();
   ...
}