ExecutorService executor = Executors.newCachedThreadPool();
    // ...
    executor.shutdown();
    while ( executor.awaitTermination(1, TimeUnit.SECONDS)) {
        System.out.println("This is taking too long.");
    }