import java.util.Scanner;

//this program takes three integers from the user and outputs the sum of the largest two numbers, the difference of the largest and smallest number, and the product of the smallest two numbers.
// done by Nadim Baraky
public class OperationsOnNumbers {


    public static void main(String[] args) {

     //declare three integer variables
     int firstMax, secondMax, min;

     //firstMax: largest number; secondMax: the number in between; min: the smallest number.

     Scanner input = new Scanner(System.in);

     System.out.print("Enter your first number: ");
     int firstNumber = input.nextInt();

     System.out.print("Enter your second number: ");
     int secondNumber = input.nextInt();

     System.out.print("Enter your third number: ");
     int thirdNumber = input.nextInt();

     input.close();


     firstMax = Math.max(Math.max(firstNumber, secondNumber),thirdNumber);

     if(firstMax == firstNumber) {
            secondMax = Math.max(secondNumber, thirdNumber);
     } 

     else if(firstMax == secondNumber) {
            secondMax = Math.max(firstNumber, thirdNumber);
     }

     else {
            secondMax =  Math.max(firstNumber, secondNumber);
     }

     min = Math.min(Math.min(firstNumber, secondNumber), thirdNumber);      

     System.out.println("The sum of the largest two numbers is: " + (firstMax + secondMax));
     System.out.println("The difference of the largest and smallest numbers is: " + (firstMax - min));
     System.out.println("The product of the smallest two numbers: " + secondMax * min);

    }

}