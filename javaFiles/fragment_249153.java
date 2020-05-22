void submitTaskChunks(int chunkCount, int chunkSize, long delayMillis) throws InterruptedException {
    ExecutorService executorService = Executors.newCachedThreadPool();

    for (int i = 0; i < chunkCount; i++) {
        List<Callable<Void>> taskChunk = IntStream.range(0, chunkSize)
                .mapToObj(k -> taskProvider.get())
                .collect(Collectors.toList());

        executorService.invokeAll(taskChunk);
        Thread.sleep(delayMillis);
    }

    executorService.shutdown();
    executorService.awaitTermination(1, TimeUnit.MINUTES);
}