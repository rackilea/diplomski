ExecutorService ex = Executors.newFixedThreadPool(nrofthreads, 
    new ThreadFactory() {
        public Thread newThread(final Runnable r) {
            return new Thread(new Runnable() {
                public void run() {
                    try {
                        r.run();
                    } finally {
                        tearDownThreadLocals();
                    }
                }
            });
        }
    });