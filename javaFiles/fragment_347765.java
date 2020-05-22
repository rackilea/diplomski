CountDownLatch latch = new CountDownLatch(filtered.size());
filtered.forEach(f -> {
    CompletableFuture.runAsync(new HeatmapAdderHelper(f))
                     .thenRun(latch::countDown);
});
latch.await();
createImage();