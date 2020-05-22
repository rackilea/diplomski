import java.lang.*;

public class T {
  public static void main(String[] args) {
    String s = "1090412";
    for (int i = 10; i <= 20; i++) {
      s = s.replace(Integer.toString(i), "" + (char)(i + 55));
    }
    System.out.println(s);
  }
}