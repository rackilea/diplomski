import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(
          new InputStreamReader (System.in)));
    for(;;) {
      System.out.println(in.next());
    }
  }
}