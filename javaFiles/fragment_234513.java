AtomicBoolean wasRun = new AtomicBoolean(false);
CountDownLatch initCompleteLatch = new CountDownLatch(1);

public void initialize() {
  if (!wasRun.getAndSet(true)) {
      List<Metadata> metadata = getMetadata(true);
      List<Process> process = getProcess();
      if (!metadata.isEmpty() && !process.isEmpty()) {
          Manager.setAllMetadata(metadata, process);
      }
      startBackgroundThread();
      initCompleteLatch.countDown();
  } else {
      log.info("Waiting to ensure initialize is done.");
      initCompleteLatch.await();
      log.warn("I was already run");
  }
}