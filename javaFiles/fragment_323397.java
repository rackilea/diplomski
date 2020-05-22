public class run {
  public static void main(String[] argv) {
    System.loadLibrary("test");
    test.test1();
    HelloWorld.test2();
    HelloWorld h1 = new HelloWorld();
    h1.test3();    
  }
}