import java.util.Scanner;
import java.util.*;

public class Adam {

    public static void main(String args[]) {
        String passwrd = "password";

        String inputPassword;
        boolean b = true;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.print("Please Input Password ");

            inputPassword = sc.nextLine();

            if (inputPassword.equals(passwrd)) {

                System.out.println("Password Accepted, Loading Archive...");
                b = false;
            } else {

                System.out.println("Invalid Password");
                b = true;

            }

        } while (b);

    }
}