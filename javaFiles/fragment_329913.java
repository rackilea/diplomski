final Phaser phaser = new Phaser(1);//register one thread to arrive

 public void waitForFlush() {
    int phase = phaser.getPhase();
    phaser.awaitAdvance(phase);    
 }

  public void flush() {
      lastFlushTime = System.currentTimeMillis();
      phaser.arrive(); //signals all waiting threads on the current phase and will increment the phase by 1
  }