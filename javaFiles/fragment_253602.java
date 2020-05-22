package KeyLocks;

import java.util.concurrent.locks.Lock;

public class KeyLock
{
    private final KeyLockManager keyLockManager;
    private final String keyName;
    private final Lock lock;

    KeyLock(KeyLockManager keyLockManager, String keyName, Lock lock)
    {
        this.keyLockManager = keyLockManager;
        this.keyName = keyName;
        this.lock = lock;
    }

    @Override
    protected void finalize()
    {
        release();
    }

    public void release()
    {
        keyLockManager.releaseLock(keyName);
    }

    public void lock()
    {
        lock.lock();
    }

    public void unlock()
    {
        lock.unlock();
    }
}