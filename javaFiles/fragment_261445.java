import java.util.*;

public class Main {
  public static void main(String[] args) {
    // code
    Scanner sc = new Scanner(System.in);
    int num = sc.nextInt();
    int[] array = new int[num];
    sc.nextLine(); // advance to new line
    String line = sc.nextLine();
    line = line.replaceAll(" ", "");
    String[] temp = line.split(",");
    for (String i : temp) {
      System.out.print(i + " ");
    }
  }
}