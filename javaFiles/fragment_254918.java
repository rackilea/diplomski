import java.util.*;

public class User {
    private static Scanner in;
    public static void main(String[] args) {

        in = new Scanner(System.in);

        int userChoice;

        boolean quit = false;
        String firstName = null;
        String secondName = null;
        String email = null;
        String username = null;
        String password = null;

        do {

            System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Quit");
            userChoice = Integer.parseInt(in.nextLine());

            switch (userChoice) {

                case 1:
                    System.out.print("Enter your first name: ");
                    firstName = in.nextLine();
                    System.out.println("Enter your second name:");
                    secondName = in.nextLine();
                    System.out.println("Enter your email address:");
                    email = in.nextLine();
                    System.out.println("Enter chosen username:");
                    username = in.nextLine();
                    System.out.println("Enter chosen password:");
                    password = in.nextLine();

                    break;

                case 2:

                    String enteredUsername;
                    String enteredPassword;

                    System.out.print("Enter Username:");
                    enteredUsername = in.nextLine();
                    System.out.print("Enter Password:");
                    enteredPassword = in.nextLine();
                    if (username != null && password != null && enteredUsername.equals ( username) && enteredPassword.equals (password))
                        System.out.println("Login Successfull!");
                    else
                        System.out.println("Login Failed!");

                    break;

                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice.");
                    break;
            }

            System.out.println();

        } while (!quit);

        System.out.println("Bye!");

    }
}