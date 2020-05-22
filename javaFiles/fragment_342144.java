import java.io.*;

public class Test {
  public static void main(String[] args) {
    System.setOut(new PrintStream(System.out, true, "UTF-8"));
    System.out.println(System.getProperty("file.encoding"));
    for (File f: new File(".").listFiles) {
      System.out.println(g.getName());
    }
  }
}