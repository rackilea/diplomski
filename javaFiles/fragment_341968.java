public final synchronized void join(long millis) 
    throws InterruptedException {
    ....
    if (millis == 0) {
       while (isAlive()) {
         wait(0);  //ends up releasing lock
       }
    }
    ....
}