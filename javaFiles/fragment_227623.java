public static void executeAsParallelAfterMapV2() {
    logger.info("executeAsParallelAfterMapV2():");
    List<String> testList = getTestList();
    StreamEx<String> sequentialStream = StreamEx
            .of(testList)
            .map(item -> {
                logger.info("Mapping {}", item);
                return item + "_mapped";
            });
    logger.info("sequentialStream.isParallel(): {}", sequentialStream.isParallel());

    List<String> afterSequentialProcessing = sequentialStream.toList();
    StreamEx<String> streamOfItems = StreamEx.of(afterSequentialProcessing)
            .parallel(s3ThreadPool);
    logger.info("streamOfItems.isParallel(): {}", streamOfItems.isParallel());
    streamOfItems.forEach(item -> handleItem(item));
}