import java.util.Scanner;

public class SpaceTravel
{
      public static void main(String[] args) {

        System.out.print("Welcome to the SpaceTravel Agency\n");

        String str; //To avoid exception when user enters just an enter

        while (true) { //infinite loop

          char choix; //for getting a character

            System.out.print("What do you want to do [h for help] : ");
            Scanner sc = new Scanner(System.in);
            str=sc.nextLine();  //get input
            if(str.length()!=1) //If no characters or more than one character is entered,
            {
              System.out.println("Invalid Choice");
              continue;
            }
            choix=str.charAt(0); //get char from str

          if(choix=='q') //if char is q,break out of the while loop
              break;  
          if (choix != 'h') { //if char is not h,print invalid input and continue the loop

              System.out.println("\nUnknown command. Type h for help ");
              continue;

          }

          System.out.print("\nh : print this help page ");
          System.out.print("\nq : quit the program ");           

        }

      } 
}