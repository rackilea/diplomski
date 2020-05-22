import java.util.Scanner;

public class UserPass {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String user; //Creating user-name variable.
        String pass; //Creating password variable.
        boolean isValidUser = false;

        while(!isValidUser) {
            System.out.println("Enter username here: "); //Message to tell user to input the user-name.
            user = input.nextLine(); //Taking the users user-name input.

            System.out.println("Enter the password here: "); //Message to tell user to input the password.
            pass = input.nextLine(); //Taking the users password input.

            //Validating the users User-name and password input.
            if(user.equals("Shane") && (pass.equals("Temple"))) {
                System.out.println("Correct!"); 
                isValidUser = true;
            }
            else {
                System.out.println("The Usernname or Password that you have entered was in-correct"); 
                isValidUser = false;
            }
        }
    }
}