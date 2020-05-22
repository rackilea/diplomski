CountDownLatch a = new CountDownLatch (1);
CountDownLatch b = new CountDownLatch (1);

void one() throws InterruptedException {
  a.await();
  b.countDown();
}

void two() throws InterruptedException {
  b.await();
  a.countDown();
}