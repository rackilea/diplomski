import java.util.Scanner;

public class ScannerTest {

     public static void main(String[]args) {

            Scanner person = new Scanner(System.in);
            System.out.print("Enter age: " );
            int age = person.nextInt();

            System.out.print("Enter gender male/female: ");
            String gender = person.nextLine();
        }
}