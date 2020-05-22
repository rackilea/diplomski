import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int height = heightInInches();
        int weight = weightInPounds();
        outputBMI(height, weight);

    }

    public static int heightInInches()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("What is your height in feet between 2 and 7? " );

        int feet = input.nextInt();

        while (feet < 2 || feet > 7)
        {
          System.out.print("Retry between 2 and 7: ");
          feet = input.nextInt();
        }

        System.out.println("How many inches between 0 and 11? " );
        int inches = input.nextInt();

        while (inches < 0 || inches > 11)
        {
          System.out.print("Retry between 0 and 11: ");
          inches = input.nextInt();

        }

        int actualHeight = (feet * 12) + inches;
        System.out.println("You are this tall in inches: " + actualHeight); 
        return actualHeight;
    }

    public static int weightInPounds()
    {
        Scanner input = new Scanner(System.in);

        System.out.println("What is your weight in stone between 3 and 30? " );
        int stone = input.nextInt();

        while (stone < 3 || stone > 30)
        {
          System.out.print("Retry between 3 and 30: ");
          stone = input.nextInt();
        }

        System.out.println("How many pounds between 0 and 13? " );
        int pounds = input.nextInt();

        while (pounds < 0 || pounds > 13)
        {
          System.out.print("Retry between 0 and 13: ");
          pounds = input.nextInt();
        }
        int actualWeight =(stone * 14) + pounds;
        System.out.println("You are this heavy in pounds: " + actualWeight); 
        return actualWeight;

    }

    public static void outputBMI(int heightInInches, int weightInPounds)
    {
        double BMI = (weightInPounds * 703) / (heightInInches * heightInInches);

        System.out.println("This is your BMI: " + BMI);
    }
}