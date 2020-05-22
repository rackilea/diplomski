if (lock != null) {
        lock.release();
        lock = null;
    }
    if (lockAccessFile != null) {
        lockAccessFile.close();
        lockAccessFile = null;
    }