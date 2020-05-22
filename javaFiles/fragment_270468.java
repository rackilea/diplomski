public static class ThreadLimitedQueue {
    private final ExecutorService executorService;
    private final int limit;

    private final Object lock = new Object();
    private final LinkedList<Runnable> pending = new LinkedList<>();
    private int inProgress = 0;

    public ThreadLimitedQueue(final ExecutorService executorService, final int limit) {
        this.executorService = executorService;
        this.limit = limit;
    }

    public void submit(Runnable runnable) {
        final Runnable wrapped = () -> {
            try {
                runnable.run();
            } finally {
                onComplete();
            }
        };
        synchronized (lock) {
            if (inProgress < limit) {
                inProgress++;
                executorService.submit(wrapped);
            } else {
                pending.add(wrapped);
            }
        }
    }

    private void onComplete() {
        synchronized (lock) {
            final Runnable pending = this.pending.poll();
            if (pending == null || inProgress > limit) {
                inProgress--;
            } else {
                executorService.submit(pending);
            }
        }
    }
}