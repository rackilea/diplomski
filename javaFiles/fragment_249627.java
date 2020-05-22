public class MyLatch {
    int remaining;

    MyLatch(int count) {
        if(count < 0) throw new IllegalArgumentException();
        remaining = count;
    }
    public synchronized void await() throws InterruptedException {
        while(remaining != 0) wait();
    }
    public synchronized boolean await(long timeout, TimeUnit unit) throws InterruptedException {
        if(remaining == 0) return true;
        long deadLine = System.nanoTime() + unit.toNanos(timeout);
        while(remaining != 0) {
            long remainingTime = deadLine - System.nanoTime();
            if(remainingTime <= 0) return false;
            wait(remainingTime / 1_000_000, (int)(remainingTime % 1_000_000));
        }
        return true;
    }
    public synchronized void countDown() {
        if(remaining > 0 && --remaining == 0) notifyAll();
    }
    public synchronized long getCount() {
        return remaining;
    }
}