static final Semaphore SEMAPHORE = new Semaphore(1);
...

SEMAPHORE.take(); // blocks, only one thread is allowed to proceed

try{
   //critical section
} finally {
    SEMAPHORE.release(); // never blocks, always within a finally block
}