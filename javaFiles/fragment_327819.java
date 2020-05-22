import java.util.Scanner;

public class LauncherMain {

    static Scanner reader = new Scanner(System.in);

    //int return value
    public static int setInputValue() {
        int userInput = reader.nextInt();
        return userInput; //return the value entered
    }

    //use int return value to access value in main
    public static int tryInputValue() {
        int userInput = 0; //initialize the variable to store input      
        boolean valid = false; //boolean to enable looping until valid input is entered
        while (valid == false){      
          try {
            userInput  = setInputValue(); //get return value
            valid = true;  //set valid to true if no exception thrown
          }
          catch (java.util.InputMismatchException e) {    //remove duplicate            
            System.out.println("That wasn't an integer!");                  

          }
          finally {
           //nothing needed here
          }
        }

        System.out.println("Awesome, your value is now: " + userInput); //this will work now, since userInput is in scope

        return userInput;
    }

    public static void main(String[] args) {
        System.out.println("Enter an integer:");
        int n = tryInputValue();   //no parameter, but get the return value 

        System.out.println(n);   //you now have access to the number the user entered
    }

}