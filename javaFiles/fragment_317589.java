private final int MAX_THREADS = 1_000;
private final Semaphore semaphore = new Semaphore(MAX_THREADS);

public void methodA() throws InterruptedException {
    semaphore.acquire();

    // your code

    semaphore.release();
}

public void methodB() throws InterruptedException {
    semaphore.acquire(MAX_THREADS);
    semaphore.release(MAX_THREADS);

    // your code
}