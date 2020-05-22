final int PERMITS = Integer.MAX_VALUE;
Semaphore semaphore = new Semaphore(PERMITS);

// read
semaphore.acquire(1);
try { ... }
finally {
  semaphore.release(1);
}

// write
semaphore.acquire(PERMITS);
try { ... }
finally {
  semaphore.release(PERMITS);
}