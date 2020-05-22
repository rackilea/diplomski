package test;

import KeyLocks.KeyLock;
import KeyLocks.KeyLockManager;

public class Main
{
    private static final String KEY_NAME = "TEST_KEY";

    public static void main(String[] args)
    {
        final KeyLockManager keyLockManager = new KeyLockManager();
        KeyLock keyLock = null;
        try
        {
            keyLock = keyLockManager.getLock(KEY_NAME);
            keyLock.lock();
            try
            {
                // Do database operation on the data with the specified key name
            }
            finally
            {
                keyLock.unlock();
            }
        }
        finally
        {
            if (keyLock != null)
            {
                keyLock.release();
            }
        }
    }
}