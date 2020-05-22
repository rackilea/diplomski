public void doSmth(Long id){
    Lock lock = prLocks.computeIfAbsent(id, key -> new ReentrantLock());
    if (lock.tryLock()){
        try {
            //some code here
        } finally {
            lock.unlock();
        }
    }
}