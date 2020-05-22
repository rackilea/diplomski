static class RelatedCallables {
    private final CountDownLatch primaryLatch = new CountDownLatch(1);
    private final CountDownLatch anyLatch = new CountDownLatch(1);
    private boolean hasPrimary;

    void awaitAny() throws InterruptedException {
        anyLatch.await();
    }

    boolean awaitPrimary(long timeout, TimeUnit unit) throws InterruptedException {
        return primaryLatch.await(timeout, unit);
    }

    <T> Callable<T> wrap(final Callable<? extends T> original) {
        final boolean isPrimary = !hasPrimary;
        hasPrimary = true;

        return new Callable<T>() {
            @Override
            public T call() throws Exception {
                try {
                    return original.call();
                }
                finally {
                    anyLatch.countDown();
                    if (isPrimary) primaryLatch.countDown();
                }
            }
        };
    }
}