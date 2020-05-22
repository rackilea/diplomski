package contactmanager;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {

    public static Integer GetInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the contact manager\nMake a selection below:");
        System.out.println("1)Display Contacts\n2)Add new business contact\n3)Add new personal contact\n4)Quit");
        Integer userInput = null;
        try {
            userInput = in.nextInt();
            if (userInput < 1 || userInput > 4) {
                System.out.println("Please enter a valid selection");
                UserInterface.GetInput();
            }

        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Please enter a valid selection");
            UserInterface.GetInput();
        }

        return userInput;

    }

}