import java.util.Scanner;

public class x {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int exes = 0;
    int whys = 0;
    while (scan.hasNext())
    {
      String line = scan.next();
      if (line.equals("x="))
        exes+=scan.nextInt();
      else
        whys+=scan.nextInt();
    }
    System.out.println("X: " + exes);
    System.out.println("Y: " + whys);
  }
}