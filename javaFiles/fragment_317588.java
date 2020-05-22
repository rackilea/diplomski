private final Lock lock = new ReentrantLock();
private final Semaphore semaphore = new Semaphore(1);
private int threadsInA = 0;

public void methodA() {
    lock.lock();
    threadsInA++;
    semaphore.tryAcquire();
    lock.unlock();

    // your code

    lock.lock();
    threadsInA--;
    if (threadsInA == 0) {
        semaphore.release();
    }
    lock.unlock();
}

public void methodB() throws InterruptedException {
    semaphore.acquire();
    semaphore.release();

    // your code
}