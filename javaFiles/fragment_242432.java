import java.util.InputMismatchException;
import java.util.Scanner;

public class TestScanner {

  public static void main(String[] args) {

    Scanner scanner = null;
    int age = -1;
    do {
      try {
        scanner = new Scanner(System.in);
        System.out.println("What is your age?");
        age = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please enter a number!");
      }
    } while (age == -1);
    System.out.println("You are " + age + " years old.");

    if (scanner != null)
      scanner.close();
  }

}