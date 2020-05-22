class MyLock implements Lock {
     private final ReentrantReadWriteLock underlying; // set in constructor

     public ReentrantReadWriteLock underlying() { return underlying; }
     public void lock() { underlying.readLock().lock(); }
}