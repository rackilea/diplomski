ExecutorService executor = Executors.newSingleThreadExecutor();
Future<AtomicInteger> futureResult = executor.submit(new Callable<AtomicInteger>() {
    @Override
    public AtomicInteger call() {
        // Here I return a random integer, but you can do your proper calculation
        AtomicInteger atomicInteger = 
            new AtomicInteger(ThreadLocalRandom.current().nextInt());
        System.out.println(Thread.currentThread().getName() + " " + atomicInteger);
        return atomicInteger;
    }
});

// Thread returns result, but continues to execute as it is a single thread pool
try {
    System.out.println(Thread.currentThread().getName() + " " + futureResult.get());
} catch (InterruptedException e) {
    // Handle exception properly
    e.printStackTrace();
} catch (ExecutionException e) {
    // Handle exception properly
    e.printStackTrace();
}

// Stop all threads
executor.shutdownNow();