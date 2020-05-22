public class BazComputationFuture implements Future<Baz>, BazComputationSink {

    private volatile Baz result = null;
    private volatile boolean cancelled = false;
    private final CountDownLatch countDownLatch;

    public BazComputationFuture() {
        countDownLatch = new CountDownLatch(1);
    }

    @Override
    public boolean cancel(final boolean mayInterruptIfRunning) {
        if (isDone()) {
            return false;
        } else {
            countDownLatch.countDown();
            cancelled = true;
            return !isDone();
        }
    }

    @Override
    public Baz get() throws InterruptedException, ExecutionException {
        countDownLatch.await();
        return result;
    }

    @Override
    public Baz get(final long timeout, final TimeUnit unit)
            throws InterruptedException, ExecutionException, TimeoutException {
        countDownLatch.await(timeout, unit);
        return result;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public boolean isDone() {
        return countDownLatch.getCount() == 0;
    }

    public void onBazResult(final Baz result) {
        this.result = result;
        countDownLatch.countDown();
    }

}

public Future<Baz> doSomething(Foo fooArg, Bar barArg) {
    BazComputationFuture future = new BazComputationFuture();
    doSomethingAsync(fooArg, barArg, future);
    return future;
}

public Baz doSomethingAndBlock(Foo fooArg, Bar barArg) {
    return doSomething(fooArg, barArg).get();
}