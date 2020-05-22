package utfexample;

import java.io.Console;

public class UTFExample {

    public static void main(String[] args) {
        Console console = System.console();
        if (console == null) {
            System.err.println("No console");
            System.exit(1);
        }
        String command = console.readLine("Enter command: %n");
        System.out.format("command: %s%n", command);
        if (command.equals("Č")) {
            System.out.println("Test was successful!");
        }
    }

}