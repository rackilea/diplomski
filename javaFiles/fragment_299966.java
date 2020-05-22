boolean waiting = true;
while(waiting) {
  int stableSValue = s.get();
  if(stableSValue == 0) {
    System.out.println("Waiting.  S was 0");
  } else {
    if(s.compareAndSet(stableSValue, stableSValue-1)) {
      System.out.println("Wait done.");
      waiting = false;
    } else {
      System.out.println("Optimistic locking failure.  Trying again.");
    }
  }
}