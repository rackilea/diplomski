this.ses = Executors.newScheduledThreadPool(CORE_POOL_SIZE, new ThreadFactory() {

            @Override
            public Thread newThread(Runnable r) {
                System.out.println("Creating thread");
                return new Thread(r);
            }
        });