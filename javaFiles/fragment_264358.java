static class StoppableExecutor implements Executor {
    final ExecutorService executor;
    final List<Future<?>> futures = Lists.newArrayList();
    boolean stopped;

    public StoppableExecutor(ExecutorService executor) {
        this.executor = executor;
    }

    void stop() {
        this.stopped = true;
        synchronized (futures) {
            for (Iterator<Future<?>> iterator = futures.iterator(); iterator.hasNext();) {
                Future<?> future = iterator.next();
                if (!future.isDone() && !future.isCancelled()) {
                    System.out.println(future.cancel(true));
                }
            }
            futures.clear();
        }
    }

    @Override
    public void execute(Runnable command) {
        if (!stopped) {
            synchronized (futures) {
                Future<?> newFuture = executor.submit(command);
                for (Iterator<Future<?>> iterator = futures.iterator(); iterator.hasNext();) {
                    Future<?> future = iterator.next();
                    if (future.isDone() || future.isCancelled())
                        iterator.remove();
                }
                futures.add(newFuture);
            }
        }
    }
}