public boolean remove(Object o) {
       if (o == null) return false;
       fullyLock();
       try
       {
       // ...
       }   
       finally {
         fullyUnlock();
       }
    }

   /**
     * Lock to prevent both puts and takes.
     */
    void fullyLock() {
        putLock.lock();
        takeLock.lock();
    }

    /**
     * Unlock to allow both puts and takes.
     */
    void fullyUnlock() {
        takeLock.unlock();
        putLock.unlock();
    }