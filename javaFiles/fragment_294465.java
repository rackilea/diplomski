try {
    // Useless as we are creating a new lock
    (new ReentrantLock).tryLock(20, TimeUnit.SECONDS).tryLock(20, TimeUnit.SECONDS).tryLock(20, TimeUnit.SECONDS);
    ...
}finally{
    // Useless too, and will actually throw because we unlock a fresh (thus unlocked) lock
    (new ReentrantLock).unlock()
}