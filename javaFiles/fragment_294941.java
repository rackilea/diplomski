import java.util.Scanner;

public class DiceGame {

    public static int attempt = 1;
    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int dice1 = (int) (Math.random() * 6 + 1);
        int dice2 = (int) (Math.random() * 6 + 1);
        int sum = dice1 + dice2;

        while (true) {
            System.out.println();
            System.out.println("Rolling dice for " + attempt + " time!");

            dice1 = (int) (Math.random() * 6 + 1);
            dice2 = (int) (Math.random() * 6 + 1);
            sum = dice1 + dice2;

            System.out.println("Roll: total = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Sorry with a " + sum + " you loose :(!");
                System.out.println();
                break;
            } else if (sum == 7 || sum == 11) {
                System.out.println("With a " + sum + " you win :)!");
                System.out.println();
                break;
            }
            System.out.println();
            System.out.println("Do you wish to continue? Press 'y' for YES or ANY key for EXIT");
            if (!scanner.next().equalsIgnoreCase("y")) {
                break;
            }
            attempt++;
        }
        System.out.println("Thanks for playing dice game, you rolled the dice " + attempt + " times!");
    }
}