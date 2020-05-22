import java.util.Scanner;

public class Test {

    public static void main(String... args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter your choice:"); // if reading from standard input (waiting from the keyboard), this is useful.
        int userInput = input.nextInt();

        int action1 = 1;
        //action1 = input.nextInt(); // I commented this out because I do not think it is useful
        int action2 = 2;
        //action2 = input.nextInt(); // I commented this out because I do not think it is useful
        int action3 = 3;
        //action3 = input.nextInt(); // I commented this out because I do not think it is useful
        int action4 = 4;
        //action4 = input.nextInt(); // I commented this out because I do not think it is useful

        if (userInput == action1) {
            System.out.println("You strike the goblin with your sword for 12 damage.");
        } else if (userInput == action2) {
            System.out.println("You cast the weaken spell on the goblin.");
        } else if (userInput == action3) {
            System.out.println("You focus and charge your magic power.");
        } else if (userInput == action4) {
            System.out.println("You run away!");
        } else{
            System.out.println("Wrong choice!");
        }
    }

}