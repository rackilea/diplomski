ForkJoinPool.managedBlock(new ManagedBlocker() {

    boolean isReleasable = false;

    @Override
    public boolean block() throws InterruptedException {
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException aE) {
            throw new IllegalStateException(aE);
        }
        return isReleasable = true;
    }

    @Override
    public boolean isReleasable() {
        return isReleasable;
    }
});