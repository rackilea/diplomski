...
mapLock.lock();
Lock fileLock = fileMap.get(fileName);
if (fileLock == null)
{
    fileLock = new ReentrantLock();
    fileLock.lock();
    fileMap.put(fileName, fileLock);
    mapLock.unlock();    

    // download and deal with file

    mapLock.lock();
    fileMap.remove(fileName);
    fileLock.unlock();
    map.unlock();
}
else // someone is downloading this file!
{
    mapLock.unlock();
    fileLock.lock();
    fileLock.unlock(); 

    // When you get here, you know the other thread has downloaded the file
    // do whatever it is you need to do in that case
}