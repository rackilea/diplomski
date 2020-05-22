import java.util.Scanner;
public class ArrayProgram2
{ 
public static void main(String[]args)
{
    Scanner scan = new Scanner(System.in);
    double [] numberList = new double[10];
    double [] largerList = new double [10];
    int largerCounter = 0;
    double sum = 0;

    for(int i = 0; i < 10; i++){
        System.out.print("Please enter any number: ");
        numberList[i] = scan.nextDouble();
        sum += numberList[i];
    }    
    double average = sum/numberList.length;
    for(int i = 0; i < 10; i++){
        if(numberList[i] > average){
            largerList[largerCounter] = numberList[i];
            largerCounter++;
        }
    }
    for(int i = 0; i <largerCounter; i++){
        System.out.println("The numbers greater than the average are " + " " + largerList[i]);
    }
    System.out.println("The average of the numbers is " + average);    
}//main
}//class