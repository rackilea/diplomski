ReentrantLock lock = new ReentrantLock();
Condition cond = lock.newCondition();
lock.lock();
try {
    while (<condition does not hold>)
        cond.await();
    }       
} finally {
    lock.unlock();
}