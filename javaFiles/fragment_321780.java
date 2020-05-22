// Get an exclusive lock on the whole file
    FileLock lock = null;
    try {
        lock = channel.lock();
        doWithLockedFile(file);
    } finally {
        if(lock!=null) {
           lock.release();
         }
    }