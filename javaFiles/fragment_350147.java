ExecutorService executorService = Executors.newFixedThreadPool(CORE_COUNT);
    for (int i = 0; i < 200; i++) {
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                encrypt(file[i]);
            }
        });
    }

    // Waiting for completion
    while (!executorService.awaitTermination(100L, TimeUnit.MILLISECONDS);