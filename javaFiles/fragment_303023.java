class ReadWriteLock {
    static final int WRITE_LOCKED = -1, FREE = 0;

    private int numberOfReaders = FREE;
    private Thread currentWriteLockOwner;

    public synchronized void acquireReadLock() throws InterruptedException {
        while(numberOfReaders == WRITE_LOCKED) wait();
        numberOfReaders++;
    }
    public synchronized void releaseReadLock() {
        if(numberOfReaders <= 0) throw new IllegalMonitorStateException();
        numberOfReaders--;
        if(numberOfReaders == FREE) notifyAll();
    }
    public synchronized void acquireWriteLock() throws InterruptedException {
        while(numberOfReaders != FREE) wait();
        numberOfReaders = WRITE_LOCKED;
        currentWriteLockOwner = Thread.currentThread();
    }
    public synchronized void releaseWriteLock() {
        if(numberOfReaders!=WRITE_LOCKED || currentWriteLockOwner!=Thread.currentThread())
            throw new IllegalMonitorStateException();
        numberOfReaders = FREE;
        currentWriteLockOwner = null;
        notifyAll();
    }
}