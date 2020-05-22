import java.util.*;

class GFG {
    public static void main (String[] args) {
        int d = configureDifficulty();

        System.out.println(d);
    }



    public static int configureDifficulty() {

    String level = "1";
    System.out.println("At what difficulty would you like to play at?");
    System.out.println("Type 1 for easy, 2 for medium, 3 for hard.");

    Scanner in = new Scanner(System.in);

    while (true) {

        level = in.nextLine();
        try {
            return Integer.parseInt(level);
        }
        catch (NumberFormatException ex) {
            System.out.println("Try again");
        }
    }

}
}