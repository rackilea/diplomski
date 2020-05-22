protected class ReadLock{
    WriteLock lock;

    public ReadLock(WriteLock lock) {
        super();
        this.lock = lock;
    }

    public void lock() throws InterruptedException { //If write() then wait
        synchronized (lock) {
           System.out.println("Waiting to read: "+Thread.currentThread());
           Thread callingThread = Thread.currentThread();
           while (lock.isLocked && lock.lockedBy != callingThread) {
               lock.wait();
           }
           lock.readers++; //Increment writelocks readers
           System.out.println("Reading: "+Thread.currentThread());
       }
    }

    public void unlock() {
        synchronized (lock) {
           lock.readers--; //Subtract from writelocks readers
           lock.notify();
        }
    }

}