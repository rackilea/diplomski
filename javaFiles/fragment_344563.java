ExecutorService exec = Executors.newFixedThreadPool(4,
        new ThreadFactory() {
            public Thread newThread(Runnable r) {
                Thread t = Executors.defaultThreadFactory().newThread(r);
                t.setDaemon(true);
                return t;
            }
        });

exec.execute(YourTaskNowWillBeDaemon);