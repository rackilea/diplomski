import java.util.Scanner; //import class

public class SumOf5Digits {

  public static void main(String[] args) {

     // Read integer
     Scanner input = new Scanner(System.in);
     System.out.print("Enter a 5-digit positive integer: ");
     int number = input.nextInt();

     // Compute sum of up to five base-10 digits in the number
     int sum = 0;
     if (number > 99999) {
        System.out.println("WARNING: " + number + " has more than five base-10 digits");
     } else {
       int digit = number % 10;  System.out.println("digit[0]=" + digit);
       sum += digit;
       digit = (number/10) % 10;  System.out.println("digit[1]=" + digit);
       sum += digit;
       digit = (number/100) % 10;  System.out.println("digit[2]=" + digit);
       sum += digit;
       digit = (number/1000) % 10;  System.out.println("digit[3]=" + digit);
       sum += digit;
       digit = (number/10000) % 10;  System.out.println("digit[4]=" + digit);
       sum += digit;
     }

     // Print sum
     System.out.println("Sum=" + sum);
  }
}