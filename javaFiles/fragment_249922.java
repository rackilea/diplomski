public class Test {
  public static void method() throws Exception {
    Thread.currentThread().interrupt();
    Thread.sleep(100);
    System.out.println("method done");
  }
  public static void main(String[] args) throws Exception {
    method();
    System.out.println("done");
  }
}