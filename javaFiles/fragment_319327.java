class FinalizerThreadFactory implements ThreadFactory {
    private final ThreadFactory delegate;
    public FinalizerThreadFactory(ThreadFactory delegate) {
        this.delegate = delegate;
    }
    public Thread newThread(final Runnable r) {
        return delegate.newThread(new Runnable() {
            public void run() {
                try {
                    r.run();
                } finally {
                    // finalizer code goes here.
                }
            }
        });
    }
}