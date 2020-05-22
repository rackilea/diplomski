package gametester;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameTester {

    public static String question;
    public static int questionCount = 0;
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        playQuiz();
    }

    private static void playQuiz() {
        boolean playAgain = true;
        System.out.println("First Question:");
        while (playAgain) {
            question = Multiplier.generateProblem();
            System.out.println(question);
            int userAnswer = getAnswer();
            playAgain = processAnswer(userAnswer);
        }
    }

    private static int getAnswer() {
        int answer = 0;
        while (true) {
            answer = 0;
            // Trap any non-numerical answers from User 
            try {
                answer = s.nextInt();
                s.nextLine();
            } catch (InputMismatchException ex) {
                // Needed to clear the scanner buffer otherwise
                // this catch clause will play over and over again
                // indefinately. 
                s.nextLine();
                // Display an Input fault to User.
                System.err.println("Incorrect Numerical Response Provided "
                        + "(Numbers only please)! Try Again.\n");
                // Get another answer from User.
                continue;   
            }
            break; // Good input, get outta this loop
        }
        return answer;
    }

    private static boolean processAnswer(int userAnswer) {
        boolean pAgain = false;
        if (userAnswer == Multiplier.checkAnswer()) {
            System.out.print("Correct!! ");
            pAgain = promptPlayAgain();
        } else {
            System.out.println("Sorry, the answer is incorrect. Try again!");
            for (int i = 0; i <= 1; i++) {
                System.out.print(question);
                System.out.println("  (Attempt #: " + (i+2) + ")");
                int ans = getAnswer();

                if (i != 1 && ans != Multiplier.checkAnswer()) {
                    System.out.println("Sorry, the answer is incorrect. Try again!");
                } else if (i == 1 && ans != Multiplier.checkAnswer()) {
                    System.out.println("The correct answer was " + Multiplier.checkAnswer());
                    pAgain = promptPlayAgain();
                } else {
                    System.out.print("Correct!! ");
                    pAgain = promptPlayAgain();
                    break;
                }
            }
        }
        return pAgain;
    }

    private static boolean promptPlayAgain() {
        boolean pAgain = false;
        while (true) {
            System.out.println("Want to play again (y or n)?");
            String user = s.nextLine();
            if (user.toLowerCase().charAt(0) == 'n') {
                pAgain = false;
                break;
            } else if (user.toLowerCase().charAt(0) == 'y') {
                pAgain = true;
                System.out.println("\nNext Question :");
                break;
            } else {
                System.err.println("Incorrect Response ('y' or 'n' exprected)! Try Again.\n");
            }
        }
        return pAgain;
    }
}