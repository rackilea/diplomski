ExecutorService executor = Executors.newCachedThreadPool();
Callable<Object> task = new Callable<Object>() {
    public Object call() {
        String netAddress = new NetTask().execute("www.google.com").get();
        return (!netAddress.equals(""));
    }
};
Future<Object> future = executor.submit(task);
try{
    //Give the task 5 seconds to complete
    //if not it raises a timeout exception
    Object result = future.get(5, TimeUnit.SECONDS);
    //finished in time
    return result; 
}catch (TimeoutException ex){
    //Didn't finish in time
    return false;
}