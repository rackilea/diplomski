import java.util.Scanner;

public class divideByZero {

public static float quotient(float numerator, float denominator)
{
   return numerator / denominator;
}

public static void main(String args[])
{
   Scanner scanner = new Scanner(System.in);

    System.out.print("Please enter the first number: ");

    int numerator = scanner.nextInt();

    System.out.print("Please enter the second number: ");

    int denominator = scanner.nextInt();

    float result = quotient( (float) numerator, (float) denominator );

    System.out.printf("\n The first number %d divided by the second number "
            + "%d = %f\n", numerator, denominator, result );

}