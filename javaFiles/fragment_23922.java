public class GCTester {
  public static final GCTester INSTANCE=new GCTester();

  private GCTester() {
    System.out.println(this + " created");
  }

  public void finalize() {
    System.out.println(this + " finalized");
  }
}