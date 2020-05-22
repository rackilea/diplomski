import java.util.Scanner;

public class problem4
{
    private static Scanner input;
    public static void main(String[] args)  
    {
        input = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int n = input.nextInt();
        for (int i = n; i > 0; i--)
        {
            System.out.print("  " + (n + 1 - i));
            for (int j = i; j > 0; j--)
            {
                System.out.print(" X");
            }
            System.out.println();
        }

    }
}