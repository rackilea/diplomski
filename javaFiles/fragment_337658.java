ExecutorService exec = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
    List<Future<?>> futures = new ArrayList<Future<?>>(NUMBER_OF_ITEMS);
    for (Item item : getItems()) {
        futures.add(exec.submit(new Processor(item)));
    }
    for (Future<?> f : futures) {
        f.get(); // wait for a processor to complete
    }
    logger.info("all items processed");