public static void executeAsParallelAfterMapJava8Stream() throws InterruptedException {
    logger.info("executeAsParallelAfterMapJava8Stream():");
    List<String> testList = getTestList();

    s3ThreadPool.submit(() -> {
        Stream<String> streamOfItems = testList.stream()
                .map(item -> {
                    logger.info("Mapping {}", item);
                    return item + "_mapped";
                })
                .parallel();
        logger.info("streamOfItems.isParallel(): {}", streamOfItems.isParallel());
        streamOfItems.forEach(item -> handleItem(item));
    }).join();
}