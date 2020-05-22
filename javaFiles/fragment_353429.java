ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 5,
        TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),
        new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r,
                    ThreadPoolExecutor executor) {
                System.out.println("I got rejected: " + r);
                if (!executor.isShutdown()) {
                    r.run();
                }
            }
        });