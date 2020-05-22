final ExecutorService exec = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
    new SynchronousQueue<Runnable>() {
        @Override
        public Runnable take() throws InterruptedException {
            System.out.println(".take()");
            return super.take();
        }
    });
Future<?> f = exec.submit(() -> { return; });
f.get();
try {
    exec.execute(() -> {});
} catch (RejectedExecutionException e) {
    System.err.println(
        "What if this might actually happen in a super bad timing by the scheduler??");
}
exec.shutdown();