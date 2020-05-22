CountDownLatch cdl = new CountDownLatch(1);

// thread 1:
cdl.await();

// thread 2:
cdl.countDown();