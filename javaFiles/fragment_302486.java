public class Counter {
  private AtomicInteger count = new AtomicInteger();

  public Counter() {
    count.incrementAndGet();
  }

  public int getCount(){
    return count.get();
  }

  public void incrementCount(){
    count.incrementAndGet();
  }
}