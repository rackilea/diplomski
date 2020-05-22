import java.util.Random;
import java.util.Scanner;

public class ConsoleGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();
        boolean playAgain = false;
        int wins = 0, losses = 0, draw = 0;
        do {
            int num = rand.nextInt(3); // 0-2 inclusive
            System.out.println("Guess the number [0-2]: ");
            int guess = Integer.parseInt(console.nextLine());
            int computerGuess = rand.nextInt(3);
            System.out.println("You: " + guess + "\tComputer: " + computerGuess + "\tNumber: " + num);
            if (guess == num && computerGuess == num || guess != num && computerGuess != num) {
                draw++;
                System.out.println("Draw!");
            } else if (guess == num) {
                wins++;
                System.out.println("You win!");
            } else if (computerGuess == num) {
                losses++;
                System.out.println("Computer wins :(");
            }
            System.out.println("Play again [y/n]? ");
            playAgain = console.nextLine().startsWith("y");
        } while (playAgain);
        System.out.println("Wins: " + wins + "\nLosses: " + losses + "\nDraw: " + draw);
        console.close();
    }
}