import java.util.Arrays;
import java.lang.Object.*;
import java.util.Scanner;


public class DeleteElements {


  public static void main(String[] args) { 
    Scanner input = new Scanner(System.in);
    int del = 0;
    int intArray[] = {10,20,30,40,50};

    System.out.print("The array consists of: ");
    for (int i = 0; i < intArray.length; i++) {
      System.out.print(intArray[i] + ", ");
    }

    System.out.print("\nWhich number should be removed for the list? ");
    del = input.nextInt();
    System.out.println("Number to delete: " + del);



      for(int i = 0; i < intArray.length; i++){
        if (intArray[i] == del){
          System.out.println("Number found at index: " + i);
        }
      }
      System.out.println("Number not found!");

  }
}