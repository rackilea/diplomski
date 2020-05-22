public class TracingFutureTask<T> extends FutureTask<T> {
    private Throwable trace;
    private boolean done;

    public TracingFutureTask(Callable<T> callable) {
        super(callable);
    }
    public TracingFutureTask(Runnable runnable, T result) {
        super(runnable, result);
    }

    @Override
    public void run() {
        try { super.run(); }
        finally { synchronized(this) { done=true; notifyAll(); }}
    }

    @Override
    protected void setException(Throwable t) {
        trace=t;
        super.setException(t);
    }
    public synchronized Throwable getException() throws InterruptedException {
        while(!done) wait();
        return trace;
    }

    public synchronized Throwable getException(long timeout)
                        throws InterruptedException, TimeoutException {

        for(long deadline = System.currentTimeMillis()+timeout, toWait=timeOut;
            !done; toWait = deadline-System.currentTimeMillis()) {

            if ( toWait <=0 ) throw new TimeoutException(
                              "Thread did not end in " + timeout + " milliseconds!" );
            wait(toWait);
        }
        return trace;
    }

    public static <V> TracingFutureTask<V> submit(Executor e, Callable<V> c) {
        TracingFutureTask<V> ft=new TracingFutureTask<>(c);
        e.execute(ft);
        return ft;
    }
    public static <V> TracingFutureTask<V> submit(Executor e, Runnable r, V v) {
        TracingFutureTask<V> ft=new TracingFutureTask<>(r, v);
        e.execute(ft);
        return ft;
    }
}