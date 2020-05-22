import java.util.*;
import java.io.*; 
import java.util.Scanner;
public class Person
{
   public static void main(String[]args) 
   {
      int age;
      Scanner scan = new Scanner(System.in);

      System.out.println("Enter in your age.");
      age = scan.nextInt(); <---- **//This is what you are missing**

      if (age < 18) 
      {
         System.out.println("Youth is a beautiful thing.");
      } 

      else
      {
         System.out.println("Age is just a state of mind.");
      }
   }
}