// use semaphore to limit number of parallel threads
semaphore.acquire();
try {
  doMyWork();
}
finally {
  semaphore.release();
}