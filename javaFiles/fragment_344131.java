mapLock.lock();
LockSet lockSet = fileMap.get(fileName);
if (lockSet == null)
{
    lockSet = new LockSet();
    fileMap.put(fileName, lockSet);
    mapLock.unlock();

    // download and deal with file

    mapLock.lock();
    fileMap.remove(fileName);
    lockSet.lock.lock();
    lockSet.condition.signalAll();
    mapLock.unlock();
}
else // someone is downloading
{
    lockSet.lock.lock();
    mapLock.unlock();
    lockSet.condition.await();

    // once we get here, the file has finished downloading in the other thread
}