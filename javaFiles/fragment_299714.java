mainLock.lock();
    boolean canExit;
    try {
        canExit = runState >= STOP ||
            workQueue.isEmpty() ||
            (allowCoreThreadTimeOut &&
             poolSize > Math.max(1, corePoolSize)); << test poolSize here
    } finally {
        mainLock.unlock();                         << race to workerDone() begins
    }