Executor executor = Executors.newFixedThreadPool(4, new ThreadFactory() {
    AtomicInteger threadId = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "http-bio-8080-exec-" + threadId.getAndIncrement());   // custom a thread factory 
    }
});

IntStream.range(0, 10).forEach(value -> {
    executor.execute(() -> {    
        System.out.println(Thread.currentThread().getName());   // print thread name
        try {
            Thread.sleep(100);
        } catch (Exception e) {

        }
    });
});