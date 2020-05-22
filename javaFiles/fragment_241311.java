public class MyClass {
  private static final AtomicInteger count = new AtomicInteger();

  public MyClass() {
    count.incrementAndGet();
  }
}