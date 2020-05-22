package test;

import java.util.Arrays;
import java.util.Scanner;

public class Averagegrades 
{
public int min, max;
double average; 
static double sum;
static int[] gradesarray;

public static void main (String [] args)
{
    sum = 0;
    Scanner scan = new Scanner(System.in);
    gradesarray = new int[10];
    System.out.println("Please enter the 10 test grades: ");

    for (int i = 0; i < gradesarray.length; i++)
    {            
        gradesarray[i] = scan.nextInt();
        if(gradesarray[i] > 100)
        {
            System.out.println("Please enter a number within 0 - 100: ");
            gradesarray[i] = scan.nextInt();
        }
    }
    System.out.println("These are the grades you entered: "+
            Arrays.toString(gradesarray));
    System.out.println("You have entered "+gradesarray.length+" grades");

    for(double num : gradesarray)
    {
        sum = sum + num;
    }
    System.out.println("This is the sum "+sum);
}

public double averageGrades()
{
    average = sum / (double) gradesarray.length;
    return average ;
}