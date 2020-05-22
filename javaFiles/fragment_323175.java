import java.util.Scanner;

class Main {

  public static void main(String args[]) {

    int first, last, flag = 0, i, j;

    Scanner scanner = new Scanner(System.in);

    System.out.print("\nEnter the lower bound : ");
    first = scanner.nextInt();
    System.out.print("\nEnter the upper bound : ");
    last = scanner.nextInt();
    System.out.println("The prime numbers in between the entered limits are :");

    int x = 0;
    if (first<3) {
        System.out.println(2);
        x++;
    }
    for (i = first; i <= last; i++) {
      for (j = 2; j < i; j++) {
        if (i % j == 0) {
          flag = 0;
          break;
        } else {
          flag = 1;
        }
      }
      if (flag == 1) {
        x++;
        System.out.println(i + " ");
      }
    }
    System.out.println("Total number of prime numbers between " + first + " and " + last + " are " + x);
  }
}