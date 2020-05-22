ExecutorService executorService = Executors.newFixedThreadPool(5);
    executorService.submit(new Runnable() {
        public void run() {
            // do download
        }
    });