package whateverpackage;

import java.util.Scanner;

public class ActionClass {

    private Scanner scanner = new Scanner(System.in);

    // *****************************************
    public static void main(String[] args) {
        new ActionClass().startApp(args);
    }
    // *****************************************

    private void startApp(String[] args) {
        Method newObject = new Method();
        newObject.passingParameters(scanner);

        justAnotherMethod();
    }

    private void justAnotherMethod () {
        System.out.println("What's your name: ");
        String name = scanner.nextLine();
        System.out.println("Your Name is: " + name);
    }

}