class MyThreadFactory implements ThreadFactory {

    private AtomicInteger invocationCounter = new AtomicInteger();

    @Override
    public Thread newThread(Runnable runnable) {
        invocationCounter.incrementAndGet();
        return new Thread(runnable);
    }

    public int numberOfInvocations() {
        return invocationCounter.get();
    }
}