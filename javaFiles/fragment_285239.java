CountDownLatch latch = new CountDownLatch(source.size());
service2.setCountDownLatch(latch);
for (

...
if (!latch.await(...)) { // add a timeout in case is never completes)
    // failure
}