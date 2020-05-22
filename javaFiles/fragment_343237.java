CountDownLatch latch = new CountDownLatch(1); // It's a barrier which holds the execution until it is counted down by another thread
    ExecutorService exec = Executors.newFixedThreadPool(2);
    exec.submit(new Runnable() { // Your first job which tries to get connection

        @Override
        public void run() {
            connection = providerSocket.accept();
            latch.countDown(); // necessary to signal that it's enough to wait
        }
    });
    exec.submit(new Runnable() { // Your worker job which performs the check

        @Override
        public void run() {
            while(!Thread.currentThread().isInterrupted()) { // this is required for proper exit
                user.checkForExpiredUsers();
            }
        }
    });
    latch.await(); // Here the main thread will pause until a connection is acquired by the first job
    exec.shutdownNow(); // Stop our jobs by setting interrupted flag for them