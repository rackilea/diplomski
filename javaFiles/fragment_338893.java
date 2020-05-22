public class EndlessIterable implements Iterable<String> {
  static class EndlessIterator implements Iterator<String> {
   public boolean hasNext() { return true; }
   public String next() { 
     // dummy code illustrating the long running task
     try { Thread.sleep(2000); } catch(Exception e) { }
     return "" + System.currentTimeMillis();
   }
   public void remove() { throw new UnsupportedOperationException(); }
  }
  private long maxTime;
  private TimeUnit unit;

  public EndlessIterable(long maxTime, TimeUnit timeUnit) {
    this.maxTime = maxTime;
    this.unit = timeUnit;
  }
  public Iterator<String> iterator() { 
    return new TimeOutIterator<>(new EndlessIterator(), maxTime, unit);
  }
}