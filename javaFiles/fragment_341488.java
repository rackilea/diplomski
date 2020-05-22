private AtomicInteger nos_calls = new AtomicInteger();

 public void function c() {
     if (nos_calls.incrementAndGet() == 1) {
         // do the call
     }
 }