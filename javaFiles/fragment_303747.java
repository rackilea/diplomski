private final Object writeLock = new Object();

public boolean UpdateXYZStock(Stock so) {
   synchronized(writeLock) {
      ...
   }
}