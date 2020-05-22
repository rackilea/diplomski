import java.util.Random;
import java.util.Scanner;

public class Guess {

    public static void main(String[] args) {
        Random rnd = new Random();
        int rndm = rnd.nextInt(100);

        int tryn;
        Scanner sc = new Scanner(System.in);
        System.out.print("Guess: ");

        while (sc.hasNextInt()) {
            tryn = sc.nextInt();

            if (tryn == rndm) {
                System.out.println("You win.");
                break;
            } else if (tryn > rndm) {
                System.out.println("Too high.");
                System.out.print("Guess again: ");
            } else {
                System.out.println("Too low.");
                System.out.print("Guess again: ");
            }
        }

        sc.close();
    }
}