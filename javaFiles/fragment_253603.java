package KeyLocks;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class KeyLockManager
{
    private class LockEntry
    {
        int acquisitionCount = 0;
        final Lock lock = new ReentrantLock();
    }

    private final Map<String, LockEntry> locks = new HashMap<String, LockEntry>();
    private final Object mutex = new Object();

    public KeyLock getLock(String keyName)
    {
        synchronized (mutex)
        {
            LockEntry lockEntry = locks.get(keyName);
            if (lockEntry == null)
            {
                lockEntry = new LockEntry();
                locks.put(keyName, lockEntry);
            }
            lockEntry.acquisitionCount++;
            return new KeyLock(this, keyName, lockEntry.lock);
        }
    }

    void releaseLock(String keyName)
    {
        synchronized (mutex)
        {
            LockEntry lockEntry = locks.get(keyName);
            lockEntry.acquisitionCount--;
            if (lockEntry.acquisitionCount == 0)
            {
                locks.remove(keyName);
            }
        }
    }
}