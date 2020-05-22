import java.util.Scanner;

public class problem6
{
    public static void main(String[] args)
    {
        System.out.println("Please enter an integer:");

        Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt( );

        if ((number >= 100) || (number >= 50 && number <= 75)){
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }
}