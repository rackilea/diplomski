public class XyzThreadPoolExecutor extends ThreadPoolExecutor  {

public XyzThreadPoolExecutor() {
    super(3, 3, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new MyThreadFactory());
}

@Override
public void execute(Runnable command) {
    /*
     * get the context object from the calling thread
     */
    Object context = null;
    super.execute(new MyRunnable(context, command));
}

@Override
protected void beforeExecute(Thread t, Runnable r) {
    ((MyRunnable)r).updateThreadLocal((MyThread) t);
    super.beforeExecute(t, r);
}

private static class MyThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return new MyThread(r);
    }

}

private class MyRunnable implements Runnable {
    private final Object context;
    private final Runnable delegate;

    public MyRunnable(Object context, Runnable delegate) {
        super();
        this.context = context;
        this.delegate = delegate;
    }

    void updateThreadLocal(MyThread thread) {
        thread.setContext(context);
    }

    @Override
    public void run() {
        delegate.run();

    }
}

private static class MyThread extends Thread {

    public MyThread(Runnable target) {
        super(target);
    }

    public void setContext(Object context) {
        // set the context object here using thread local
    }

}
}