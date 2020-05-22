ExecutorService executorService = Executors.newFixedThreadPool(NB_THREADS);
while (currentPosition < count) {
    ExtractItemsProcessor extractItemsProcessor =
            getExtractItemsProcessor(currentPosition, currentPositionLogger);
    executorService.submit(extractItemsProcessor); // In processor you should add the sleep method
    waitBetweenProzesses += sleepTime;
    currentPosition += chunkSize;
}