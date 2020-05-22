@Override
    public BackgroundTaskResult execute(BackgroundTask backgroundTask)
        throws Exception {

    Lock lock = null;

    String owner =
        backgroundTask.getName() + StringPool.POUND +
            backgroundTask.getBackgroundTaskId();

    try {
        if (isSerial()) {
            lock = acquireLock(backgroundTask, owner);
        }

        BackgroundTaskExecutor backgroundTaskExecutor =
            getBackgroundTaskExecutor();

        return backgroundTaskExecutor.execute(backgroundTask);
    }
    finally {
        if (lock != null) {
            LockLocalServiceUtil.unlock(
                BackgroundTaskExecutor.class.getName(),
                backgroundTask.getTaskExecutorClassName(), owner);
        }
    }
}  

 protected Lock acquireLock(BackgroundTask backgroundTask, String owner)
        throws DuplicateLockException {

    Lock lock = null;

    while (true) {
        try {
            lock = LockLocalServiceUtil.lock(
                BackgroundTaskExecutor.class.getName(),
                backgroundTask.getTaskExecutorClassName(), owner);

            break;
        }
        catch (SystemException se) {
            if (_log.isDebugEnabled()) {
                _log.debug("Unable to acquire acquiring lock", se);
            }

            try {
                Thread.sleep(50);
            }
            catch (InterruptedException ie) {
            }
        }
    }

    if (!lock.isNew()) {
        throw new DuplicateLockException(lock);
    }

    return lock;
}