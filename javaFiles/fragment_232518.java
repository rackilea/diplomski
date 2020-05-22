import java.util.Scanner;  
import java.util.*;

public class Test
{
     public static void main(String []args){
         ArrayList lista = new ArrayList();
         Scanner input = new Scanner(System.in);
         String userInput;
         do {
            System.out.println("Name");
            lista.add(input.nextLine());
            System.out.println("SurName");
            lista.add(input.nextLine());
            System.out.println("wish to continue?");
            userInput = input.nextLine();
            System.out.println("your input is " + userInput);
        } while (!userInput.equalsIgnoreCase("NO"));
        //whether user types "no" or "No" or "nO" or "NO", it will consider all cases.
     }
}