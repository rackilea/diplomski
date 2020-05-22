threadPool.setRejectedExecutionHandler(new RejectedExecutionHandler() {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        try {
            // this will block the producer until there's room in the queue
            executor.getQueue().put(r);
        } catch (InterruptedException e) {
            throw new RejectedExecutionException(
                "Unexpected InterruptedException", e);
        }
    }
});