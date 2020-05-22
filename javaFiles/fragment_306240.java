package recipeNo025;

public class HelloWorld {

  public static native void pushString(String s);
  public static native String popString();

  static {
    System.loadLibrary("HelloWorld");
  }

  public static void main(String[] args) {
    HelloWorld.pushString("Hello");
    System.out.println(HelloWorld.popString());
  }
}