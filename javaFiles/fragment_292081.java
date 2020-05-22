import java.util.Scanner;
import java.lang.*;
public class Main
{
   public static void main(String args[])
   {
    Scanner input = new Scanner(System.in);
   System.out.print ("Enter 5-digit integer value: ");
   String userNumber = input.next();
    System.out.println("Input value: " + "\t" + userNumber);

      //User input incorrect amount of digits
      if (userNumber.length()!=5) 
      {
      System.out.println("Not 5 digits.");
      }   
         else{
            //Conditions are met for Palidrome Number
              if(new StringBuilder(userNumber).reverse().toString().equals(userNumber))
                {
                  System.out.println("Judgement: " + "\t" + "\t" + "True");
               }
               //Conditions are not met for Palidrome Number
               else
                     {
                  System.out.println("Judgement: " + "\t" + "\t" + "False");
                   }     
     }
   }
}