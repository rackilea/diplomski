import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        int n = 0, selection;
        ArrayList<Integer> selectionsSoFar = new ArrayList<Integer>();

        while (n < 5) {
            System.out.println("Enter Option:\n");
            selection = keyboard.nextInt();
            if (selectionsSoFar.contains(selection) || selection <= 0 || selection > 2) {
                System.out.println("Error");
            } else {
                switch (selection) {
                case 1:
                    System.out.println("1");
                    selectionsSoFar.add(selection);
                    n++;
                    break;
                case 2:
                    System.out.println("2");
                    selectionsSoFar.add(selection);
                    n++;
                    break;
                }

            }

        }
        keyboard = null;
    }

}