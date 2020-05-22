import java.util.Scanner;

public class Average {

  public static void printMultiples(int n, int max) {
    for (int i = 1; i <= max; i++) {
      if (i % n == 0) {
        System.out.println(i);
      }
    }
  }

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.println("Enter a positive integer:");
    int n = s.nextInt();
    System.out.println("Enter a maximum positive integer:");
    int max = s.nextInt();
    printMultiples(n, max);
  }
}