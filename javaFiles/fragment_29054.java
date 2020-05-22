Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new ThreadFactory()
{
    @Override
    public Thread newThread(final Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
});