import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class arrayLabFirst
{
    public static void main(String[] args) throws FileNotFoundException
    {
        double[ ] temperatures = new double[10];
        Scanner inFile = new Scanner(new File("data.txt")); 
        for (int index = 0; index < temperatures.length; index++)
            if(inFile.hasNext())
                temperatures[index] = inFile.nextDouble();
            else
                continue;

        printArray(temperatures);
        System.out.println("The average of the temperatures entered is: " + arrayAverage(temperatures));
        System.out.println("The greatest temperature is: " + greatest(temperatures));
        System.out.println("The lowest temperature is: " + lowest(temperatures));

        inFile.close();
    }
    public static void printArray(double[] temperatures)
    {
        System.out.print("Input Array:\n[");
        for (int i = 0; i < temperatures.length; i++)
        {
            System.out.print(temperatures[i]);
            if(i < temperatures.length - 1)
            {
                System.out.print(", ");
            }
        }
        System.out.println("]\n");
    }
    public static double arrayAverage(double[] temperatures)
    {
        double sum = 0;
        for (int i = 0; i < temperatures.length; i++)
            sum += temperatures[i];
        return sum/temperatures.length;
    }
    public static void countDays(double[] temperatures)
    {
        int aboveCount = 0;
        int belowCount = 0;
        for (int i = 0; i < temperatures.length; i++)
        {
            if (i > 32)
                aboveCount++;
            else
                belowCount++;
        }
        System.out.println("number of days above freezing: " + aboveCount);
        System.out.println("number of days below freezing: " + belowCount);
    }
    public static double greatest(double[] temperatures)
    {
        int maxIndex = 0;
        for (int index = 1; index < temperatures.length; index++)
            if (temperatures[maxIndex] < temperatures[index])
                maxIndex = index;

        return temperatures[maxIndex];
    }
    public static double lowest(double[] temperatures)
    {
        int minIndex = 0;
        for (int index = 1; index < temperatures.length; index++)
            if (temperatures[minIndex] > temperatures[index])
                minIndex = index;        

        return temperatures[minIndex];
    }
}