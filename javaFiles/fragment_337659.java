ExecutorService exec = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    List<Item> items = getItems();
    int minItemsPerThread = NUMBER_OF_ITEMS / NUMBER_OF_THREADS;
    int maxItemsPerThread = minItemsPerThread + 1;
    int threadsWithMaxItems = NUMBER_OF_ITEMS - NUMBER_OF_THREADS * minItemsPerThread;
    int start = 0;
    List<Future<?>> futures = new ArrayList<Future<?>>(NUMBER_OF_ITEMS);
    for (int i = 0; i < NUMBER_OF_THREADS; i++) {
        int itemsCount = (i < threadsWithMaxItems ? maxItemsPerThread : minItemsPerThread);
        int end = start + itemsCount;
        Runnable r = new Processor(items.subList(start, end));
        futures.add(exec.submit(r));
        start = end;
    }
    for (Future<?> f : futures) {
        f.get();
    }
    logger.info("all items processed");