class SomeClass {
    // ...
    final AtomicLong totalWriteCount = new AtomicLong(0);
    final AtomicLong lastDownloadSize = new AtomicLong(0);
    // ...

    private long getDownloadSize() {
        synchronized (this) {
            for (DownloadTask task : downloadTasks) {
                final long writeCount = task.getWriteCount();
                totalWriteCount.addAndGet(writeCount);
                final long downloadSize = task.getPosition().getDownloadSize();
                lastDownloadSize.addAndGet(downloadSize);
            }
            System.out.println("=====  writeCount : " + totalWriteCount + "lastDownloadSize : " + lastDownloadSize);
            return totalWriteCount.addAndGet(lastDownloadSize.get());
        }
    }
}