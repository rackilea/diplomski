public class ClientConnection {

  private static final AtomicInteger count = new AtomicInteger();

  public void open() {
    // This could also be in the constructor, depending on
    // the requirements of the object
    count.incrementAndGet();
  }

  public void close() {
    // <close out the physical connection>
    count.decrementAndGet();
  }

  public static int getConnectionCount() {
    return count.get();
  }

}