import java.util.Scanner;

public class Enter_Input {

    //create method isEven
    private static void isEven(int currentNumber) {
        if (currentNumber % 2 == 0) {
                System.out.println(currentNumber + " is even\n");
            }//end if statement
            else {
                System.out.println(currentNumber + " is odd\n");
        }//        
    }

    public static void main(String[] args) {

        int number = 0;

        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Enter number (-1 to quit): ");
            number = input.nextInt();

            if (number == -1) {                
                break;
            }//end if statement
            else  {
                Enter_Input.isEven(number);
            }//end else statement

        } while (number > 0); //end do while loop

        System.out.println("Program Terminated");
    }//end main method

}//end class