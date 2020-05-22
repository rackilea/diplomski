import java.util.Scanner;

public class Population
{
    public static void main(String[] args)
    {
        double growthRate=-1;
        int population=0;
        int days=-1;
        double popResult=0;

        Scanner keyboard=new Scanner(System.in);

        System.out.println("\nEnter the starting number of organisms:");
        population=keyboard.nextInt();

        while(population<2)
        {
            System.out.println("\nError!! Please re-enter number of organisms.");
            population=keyboard.nextInt();
        }

        System.out.println("\nEnter rate of growth as percentage:");
        growthRate=keyboard.nextInt();

        while(growthRate<0)
        {
            System.out.println("\nError!! Growth rate must be a positive number. Please re-enter.");
            growthRate=keyboard.nextInt();
        }

        System.out.println("\nEnter number of days organisms will grow:");
        days=keyboard.nextInt();

        while(days<0)
        {
            System.out.println("\nError!! Number of days cannot be less than 1. Please re-enter.");
            days=keyboard.nextInt();
        }

        System.out.println("Days" + "\t" +  "Organisms");
        System.out.println("------------------");

        popResult=population;
        growthRate=growthRate/100;

        for(int numberOfDays=1; numberOfDays<days; numberOfDays++)
        {
            System.out.println(numberOfDays + "\t" + popResult);
            popResult=(popResult * growthRate) + popResult;

        }}}