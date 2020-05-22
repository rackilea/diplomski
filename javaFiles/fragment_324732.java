public class PApplet {
  static public final String javaVersionName =
    System.getProperty("java.version");

  static public final int javaPlatform = 1;

  public static void main(String [] args) {
    System.out.println("Java version: " + javaPlatform);
  }
}