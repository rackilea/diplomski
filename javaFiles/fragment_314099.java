import java.util.Scanner;

public class apples {

public static void main(String args[]) {

    Scanner input = new Scanner(System.in);
    System.out.println("Please enter your name to begin.");
    System.out.println("Hello " + input.nextLine() + "!");

    System.out.println("Please enter your age");

    do{

         if(input.hasNextInt()){
                 System.out.println("You've entered a valid age");
                 break; 
              }

         else{
                System.out.println("Please enter an integer");
                input.next(); 
           }

    }while(true);

  }

}