private final AtomicIntegerArray accounts;
public final ReadWriteLock lock = new ReentrantReadWriteLock();

Bank(int numAccounts) {
    accounts=new AtomicIntegerArray(numAccounts);
}

// Multiple Threads are doing transactions.
public void transfer(int from, int to, int amount){
    final Lock sharedLock = lock.readLock();
    sharedLock.lock();
    try {
        accounts.addAndGet(from, -amount);
        accounts.addAndGet(to,   +amount);
    }
    finally {
        sharedLock.unlock();
    }
}

// Only one thread does summation.
public int totalMoney(){
    int sum = 0;
    final Lock exclusiveLock = lock.writeLock();
    exclusiveLock.lock();
    try {
        for(int ix=0, num=accounts.length(); ix<num; ix++)
            sum += accounts.get(ix);
    }
    finally {
        exclusiveLock.unlock();
    }
    return sum;
}