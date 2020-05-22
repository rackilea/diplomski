public void myMethod(Input input) {
    if (!this.isStreamingPaused()) {
        ExecutorService publisherThreadPool = getThreadPool();

        // in case that you'd have more of the same kind of operations to do
        // you can use appropriately a higher count than 1
        CountDownLatch  latch = new CountDownLatch(1);

        PublisherThread publisher = new PublisherThread();
        publisher.setInputData(input);
        publisherThreadPool.execute(publisher);
        publisherThreadPool.shutdown();


        try {
            latch.await();
        } catch (InterruptedException e) {
            LOG.info("Interrupted by another thread");
        } 
    }
}