ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
new Thread() {
    @Override
    public void run() {
        readWriteLock.readLock().lock();
        try {
            // block the read lock
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}.start();
if (!readWriteLock.writeLock().tryLock(1, TimeUnit.SECONDS)) {
    System.out.println(readWriteLock);
    System.out.println(readWriteLock.readLock());
    System.out.println(readWriteLock.writeLock());
}