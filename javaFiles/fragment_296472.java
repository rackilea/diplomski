private CountDownLatch latch = new CountDownLatch(1);

...

synchronized(this) {
   // do first actions
}
this.latch.countdown();

....

this.latch.await();
synchronized(this) {
    // do second
}