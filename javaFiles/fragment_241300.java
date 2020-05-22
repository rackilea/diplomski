myLock.readLock().lock();
try {
    // ...
} finally {
    myLock.readLock().lock(); // Oops! Should be "unlock()"
}