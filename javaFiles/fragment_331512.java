public class ReadTask implements Runnable {        
    private final ReadWriteLock lock;
    public ReadTask (ReadWriteLock lock) {
        this.lock = lock;
    }
    @Override public void run () {
        lock.readLock().lock();
        // do stuff
        lock.readLock().unlock();
    }
}

public class WriteTask implements Runnable {
    private final ReadWriteLock lock;
    public WriteTask (ReadWriteLock lock) {
        this.lock = lock;
    }
    @Override public void run () {
        lock.writeLock().lock();
        // do stuff
        lock.writeLock().unlock();
    }
}