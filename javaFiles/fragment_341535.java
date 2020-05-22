import java.util.Scanner;

public class Tuna { // Classes should always begin with an uppercase letter

    // Moved object attributes into method
    public void options() {
        // Now input is read if options() gets called
        Scanner input = new Scanner(System.in);
        String answer = input.nextLine();
        switch(answer) {
        case "a":
            System.out.println("answer a");
            break;
        case "b":
            System.out.println("answer b");
            break;
        case "c":
            System.out.println("answer c");
        }
        input.close(); // Close stream when we are done
    }
}