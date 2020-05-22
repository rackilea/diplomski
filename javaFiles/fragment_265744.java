ExecutorService pool = Executors.newSingleThreadExecutor();
CompletionService<Boolean> completionService = new ExecutorCompletionService<>(pool);

Callable<Boolean> callable = new Callable<Boolean>(){
    public Boolean call() {
        Boolean result = true;
        //callbackAsync();  //calls an async method that returns immediately, but will trigger a broadcast intent back to main thread
        return result;
    }
};

completionService.submit(callable);

new broadCastReceiver() { ///back on main thread
    .....
    Future<Boolean> future = completionService.take(); //Will wait for future to complete and return the first completed future   
    case ACTION_CALLABLE_COMPLETE: future.get();