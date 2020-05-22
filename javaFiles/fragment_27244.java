ExecutorService executor = Executors.newSingleThreadExecutor();
TracingFutureTask<String> future=TracingFutureTask.submit(executor, new Callable<String>(){
    @Override
    public synchronized String call() throws Exception {
        this.wait( 60000 );
        return "foo";                   
    }
});
try {
    future.get(500, TimeUnit.MILLISECONDS);
    fail("Timeout expected.");
} catch (ExecutionException | TimeoutException e) {
    e.printStackTrace();
}
if(future.cancel(true)) {
    System.err.println("cancelled.");
    Throwable t = future.getException();
    if(t!=null) t.printStackTrace(System.err.append("cancellation caused "));
}