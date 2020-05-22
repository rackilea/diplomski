import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Until what?");
    int n = scanner.nextInt();

    int count = 0;
    int sum = 0;
    while(count <= n) {
      sum += count; // increment the sum variable by the value of count
      count++; // increment the count variable by 1
    }

    System.out.println("Sum is " + sum);
  }
}