mutex.lock();
try {
   // do your stuff
   threads[id].await();
} finally {
   mutex.unlock();
}