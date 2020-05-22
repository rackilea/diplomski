import java.util.Scanner;

public class AverageNumber {

public static void main(String[] args) {

Scanner input = new Scanner(System.in);

System.out.print("How many numbers will you enter: ");
int numberOfTimes = input.nextInt();

double AverageMean = 0;
double[] Array = new double[numberOfTimes];

// Doing the first loop as suggested
for(int i = 0; i < numberOfTimes; i++)
{
    System.out.print("Enter a decimal value: ");
    Array[i]  = input.nextDouble();
}

// Doing the second loop as suggested
for(int i = 0; i < numberOfTimes; i++)
{
    AverageMean = AverageMean + Array[i];
}

System.out.println("The average is " + AverageMean/5);

}

}