Semaphore semaphore = new Semaphore(0);
...
semaphore.acquire(5);

// Other thread... in a loop
semaphore.release(); // When this has executed 5 times, first thread will unblock