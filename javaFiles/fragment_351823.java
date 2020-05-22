public Relations()
{
    synchronized(Relations.class) // a lock on currentLockOrder
    {
        lockOrder = currentLockOrder;
        ++currentLockOrder;
    }
}