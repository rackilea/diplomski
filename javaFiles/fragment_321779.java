// Get an exclusive lock on the whole file
    FileLock lock = channel.lock();
    try {
        lock = channel.lock();
        doWithLockedFile(file);
    } finally {
        lock.release();
    }