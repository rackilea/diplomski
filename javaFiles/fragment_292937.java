public class Test {

  // this is guaranteed to be initialized after the constructor
  private final int val;

  public Test(int v) {
    new Thread(new Runnable() {
      @Override public void run() {
        System.out.println("Val is " + val);
      }
    }).start();
    this.val = v;
  }

}