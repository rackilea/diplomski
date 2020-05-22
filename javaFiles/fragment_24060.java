// creating a thread pool.
ExecutorService service = Executors.newSingleThreadExecutor(new ThreadFactory() {
    @Override
    public Thread newThread(Runnable r) {
        // creating a thread.
        Thread two = new Thread(r, "two");
        // making it a daemon thread.
        two.setDaemon(true);
        return two;
    }
});

for(int i=0;i<10;i++)
    // creating a task and submitting it.
    service.submit(new Runnable() {
        @Override
        public void run() {
            System.out.println("["+Thread.currentThread().getName()+"] - Hello World.");
            Thread.yield();
        }
    });
service.shutdown();