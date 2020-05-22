private CountDownLatch m2latch = new CountDownLatch(1);
private CountDownLatch m3latch = new CountDownLatch(1);

public void m1() {
  // handle input
  m2latch.countDown();
}

public void m2() {
  m2latch.await();
  // handle input (m1 has been called)
  m3latch.countDown();
}

public void m3() {
  m3latch.await();
  // do output (both m1 + m2 have been called)
}