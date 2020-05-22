import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input number: ");
        String n = in.nextLine();
        if (n.matches("[0-9]+")) {
            System.out.println(n + " + " + n + n + " + " + n + n + n + " = "
                    + (Integer.parseInt(n) + Integer.parseInt(n + n) + Integer.parseInt(n + n + n)));
        } else {
            System.out.println("Error: invalid input.");
        }
    }
}