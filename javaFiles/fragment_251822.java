import java.util.Scanner;

public class calculate {

/**
 * @param args
 */
public static void main(String[] args) {
    // TODO Auto-generated method stub

    //variable to store user input
    String userinputOperation;
    int userinputNumber;
    int userinputNumber2; 
    int result;

    //user input variables
    Scanner myscanner = new Scanner(System.in);
    Scanner number1 = new Scanner(System.in);
    Scanner number2 = new Scanner(System.in);

    //different options for calculator i.e., add, subtract, divide, multiply.
    String one = "Add"; // addition
    String two = "Subtract"; // subtract
    String three = "Multiply"; // multiplication
    String four = "Divide"; // division
    String five = "Exit the application."; // exit

    //explain how to use application
    System.out.print("Welcome to Barney's Calculator.");
    System.out.println(" What would you like to do?");
    System.out.println("Write 'one' to add two numbers.");
    System.out.println("Write 'two' to subtract two numbers.");
    System.out.println("Write 'three' to multiply two numbers together.");
    System.out.println("Write 'four' to divide two numbers.");
    System.out.println("Write 'five' to exit.");



    //obtain user input
    userinputOperation = myscanner.nextLine();

    //explain what user has selected
    if (userinputOperation.equals("one")) //add
    System.out.print("You have chosen to " + one + " two numbers");

    if (userinputOperation.equals("two")) //subtract
    System.out.print("You have chosen to " + two + " two numbers");

    if (userinputOperation.equals("three")) //multiply
    System.out.print("You have chosen to " + three + " two numbers");

    if (userinputOperation.equals("four")) //divide
    System.out.print("You have chosen to " + four + " two numbers");

    if (userinputOperation.equals("five")) //exit
    System.out.print("You have chosen to " + one);

    //obtain what the numbers the user wants to operate with

    System.out.println("Input the first number you want to operate with: ");
    userinputNumber = number1.nextInt();

    System.out.println("Input the second number you want to operate with: ");
    userinputNumber2 = number2.nextInt();

    //calculate stuff

    if (userinputOperation == "one") //add the numbers
    result=(userinputNumber + userinputNumber2);
    System.out.print(result);

    if (userinputOperation == "two") //subtract the numbers
    result=(userinputNumber - userinputNumber2);
    System.out.print(result);

    if (userinputOperation == "three") //multiply
    result=(userinputNumber * userinputNumber2);
    System.out.print(result);

    if (userinputOperation == "four") //add
    result=(userinputNumber / userinputNumber2);
    System.out.print(result);


}

}