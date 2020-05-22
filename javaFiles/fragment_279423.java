try {
  mutex.acquire();
  try {
    // do something
  } finally {
    mutex.release();
  }
} catch(InterruptedException ie) {
  // ...
}