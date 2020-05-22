private final CountDownLatch latch = new CountDownLatch(1);

public void run() {
  try {
    do {
      //doSomething
    } while (true);
  } finally {
    latch.countDown();
  }
}

public void waitForSomething() throws InterruptedException {
  latch.await();
  //something
}