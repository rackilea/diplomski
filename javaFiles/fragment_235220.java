private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); //the reentrant impl

....

public void readMethod() {

    readWriteLock.readLock().lock();

    try {
        //code that simply _reads_ your object
    } finally {
        readWriteLock.readLock().unlock();
    }

}

public void writeMethod() {

     readWriteLock.writeLock().lock();

     try {
        //... code that modifies your shared object / objects
     } finally {
         readWriteLock.writeLock().unlock();
     }
}