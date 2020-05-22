private final ThreadPoolExecutor executor = new ThreadPoolExecutor (new ThreadPoolExecutor(10, 10,  0L, TimeUnit.MILLISECONDS,  new LinkedBlockingQueue<Runnable>()){   
    protected void beforeExecute(Thread t, Runnable r) { 
         t.setName(deriveRunnableName(r));
    }

    protected void afterExecute(Runnable r, Throwable t) { 
         Thread.currentThread().setName("");
    } 

    protected <V> RunnableFuture<V> newTaskFor(final Runnable runnable, V v) {
         return new FutureTask<V>(runnable, v) {
             public String toString() {
                return runnable.toString();
             }
         };
     };
}