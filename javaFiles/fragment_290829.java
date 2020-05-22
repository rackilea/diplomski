ExecutorService executor = Executors.newFixedThreadPool(1);
    Runnable formatConcentration = new formatConcentration(87);
    executor.execute(formatConcentration);
    executor.shutdown();
    try {
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }