import java.util.Scanner;

public class Blahh
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int largest = 0;

        int a = scan.nextInt(); // First number input by user
        int b = scan.nextInt();
        largest = largest(a, b);

        int c = scan.nextInt();
        largest = largest(largest, c);

        int d = scan.nextInt();
        largest = largest(largest, d);

        int e = scan.nextInt();

        System.out.println("The largest number is: " + largest(largest, e));
    }

    public static int largest(int num1, int num2)
    {
        if (num1 > num2)
            return num1;
        else
            return num2;
    }
}