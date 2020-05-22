Lock lock = new ReentrantLock();
......
if (lock.tryLock())
{
    // Got the lock
    try
    {
        // Process record
    }
    finally
    {
        // Make sure to unlock so that we don't cause a deadlock
        lock.unlock();
    }
}
else
{
    // Someone else had the lock, abort
}