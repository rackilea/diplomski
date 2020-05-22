ExecutorService service = Executors.newCachedThreadPool(new ThreadFactory() {
    final String processName = ManagementFactory.getRuntimeMXBean().getName();
    final AtomicLong counter = new AtomicLong();
    @Override
    public Thread newThread(Runnable r) {
        String name = processName+"-"+counter.getAndIncrement();
        return new Thread(r, name);
    }
});
for(int i=0;i<10;i++)
    service.submit(new Runnable() {
        @Override
        public void run() {
            System.out.println("["+Thread.currentThread().getName()+"] - Hello World.");
            Thread.yield();
        }
    });
service.shutdown();