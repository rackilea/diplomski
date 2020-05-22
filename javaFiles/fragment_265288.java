CountDownLatch latch = new CountDownLatch(5);
...
latch.await(); // Possibly put timeout


// Other thread... in a loop
latch.countDown(); // When this has executed 5 times, first thread will unblock