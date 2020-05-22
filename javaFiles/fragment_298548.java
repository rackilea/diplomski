ExecutorService executor = Executors.newCachedThreadPool(new ThreadFactory() {
     @Override
     public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
     }
});