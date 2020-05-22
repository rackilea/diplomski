public class Bank {
    private final AtomicInteger[] accounts;
    public final ReadWriteLock lock = new ReentrantReadWriteLock();
    Bank(int numAccounts) {
        // initialize, keep in mind that this array MUST NOT change
        accounts=new AtomicInteger[numAccounts];
        for(int i=0; i<numAccounts; i++) accounts[i]=new AtomicInteger();
    }

    // Multiple Threads are doing transactions.
    public void transfer(int from, int to, int amount){
        final Lock sharedLock = lock.readLock();
        sharedLock.lock();
        try {
            accounts[from].addAndGet(-amount);
            accounts[to  ].addAndGet(+amount);
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
            for(AtomicInteger account: accounts)
                sum += account.get();
        }
        finally {
            exclusiveLock.unlock();
        }
        return sum;
    }
}