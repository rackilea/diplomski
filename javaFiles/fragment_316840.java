Semaphore semaphore = new Semaphore(pool_size);

//critical section
semaphore.acquire();

...

semaphore.release();