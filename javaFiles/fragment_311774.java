public final class ListenablePool<K, V> {

    private final GenericKeyedObjectPool<K, V> delegate;

    private final CountDownLatch closeLatch = new CountDownLatch(1);

    private final AtomicBoolean closed = new AtomicBoolean();

    public ListenablePool(final KeyedPoolableObjectFactory<K, V> factory) {
        this.delegate = new GenericKeyedObjectPool<K, V>(factory);
    }

    public V borrowObject(final K key) throws Exception {
        return delegate.borrowObject(key);
    }

    public void returnObject(final K key, final V obj) throws Exception {
        try {
            delegate.returnObject(key, obj);
        } finally {
            countDownIfRequired();
        }
    }

    private void countDownIfRequired() {
        if (closed.get() && delegate.getNumActive() == 0) {
            closeLatch.countDown();
        }
    }

    public void close() throws Exception {
        try {
            delegate.close();
        } finally {
            closed.set(true);
            countDownIfRequired();
        }
    }

    public void awaitTermination() throws InterruptedException {
        closeLatch.await();
    }

    public void awaitTermination(final long timeout, final TimeUnit unit) 
            throws InterruptedException {
        closeLatch.await(timeout, unit);
    }

    public int getNumActive() {
        return delegate.getNumActive();
    }

    // other delegate methods
}