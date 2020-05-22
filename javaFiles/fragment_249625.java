public class MyLatch {
    final ReentrantLock lock = new ReentrantLock();
    final Condition zeroReached = lock.newCondition();
    int remaining;

    MyLatch(int count) {
        if(count < 0) throw new IllegalArgumentException();
        remaining = count;
    }
    public void await() throws InterruptedException {
        lock.lock();
        try {
            while(remaining != 0) zeroReached.await();
        }
        finally {
            lock.unlock();
        }
    }
    public boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        lock.lock();
        try {
            if(remaining == 0) return true;
            long deadLine = System.nanoTime() + unit.toNanos(timeout);
            while(remaining != 0) {
                final long remainingTime = deadLine - System.nanoTime();
                if(remainingTime <= 0) return false;
                zeroReached.await(remainingTime, TimeUnit.NANOSECONDS);
            }
            return true;
        }
        finally {
            lock.unlock();
        }
    }
    public void countDown() {
        lock.lock();
        try {
            if(remaining > 0 && --remaining == 0) zeroReached.signalAll();
        }
        finally {
            lock.unlock();
        }
    }
    public long getCount() {
        lock.lock();
        try {
          return remaining;
        }
        finally {
            lock.unlock();
        }
    }
}