// Try acquiring the lock without blocking. This method returns
// null or throws an exception if the file is already locked.
        try {
            lock = channel.tryLock();
        } catch (OverlappingFileLockException e) {
            // File is already locked in this thread or virtual machine
        }