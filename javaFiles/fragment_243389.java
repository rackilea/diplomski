import java.util.Scanner;

public class Programming {

    /*
     * get the number of matching digits between the guess and the 
     * answer, ignoring repeated matches
     */
    public static int numberDigitsMatch(String guess, String answer) {

        int numberMatch = 0;
        int currentIndex = 0;
        int matchingIndex;
        while (currentIndex < guess.length()) {

            // check if the current digit of the guess is in the answer
            matchingIndex = answer.indexOf(guess.charAt(currentIndex));

            if (matchingIndex < 0) {
                currentIndex++;
            }
            else {

                currentIndex++;
                numberMatch++;

                // remove the no longer relevant character from the answer 
                answer = answer.substring(0, matchingIndex) +
                    answer.substring(matchingIndex + 1);
            }


        }

        return numberMatch;
    }




    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // generate the winning number
        int lotteryNumber = (int) (Math.random() * 10000);
        String lotteryString = "" + lotteryNumber;

        System.out.println("The lottery number is " + lotteryString);

        // Prompt the user to enter a guess
        System.out.print("Enter your lottery pick (four digits): ");

        // get the user's guess
        int guessNumber = in.nextInt();
        String guessString = "" + guessNumber;

        // NOTE: these guessDigit numbers are not necessary. I am leaving
        // them here so you can see how to pick out individual digits
        int guessDigit1 = guessNumber % 10;
        int guessDigit2 = (guessNumber / 10) % 10;
        int guessDigit3 = (guessNumber / 100) % 10;
        int guessDigit4 = (guessNumber / 1000) % 10;

        int lotteryDigit1 = lotteryNumber % 10;
        int lotteryDigit2 = (lotteryNumber / 10) % 10;
        int lotteryDigit3 = (lotteryNumber / 100) % 10;
        int lotteryDigit4 = (lotteryNumber / 1000) % 10;

        System.out.println("The lottery number is " + lotteryString);

        int numMatchingDigits = numberDigitsMatch(guessString, lotteryString);

        if (guessNumber == lotteryNumber) {
            System.out.println("Exact match: you win $10,000");
        }
        else if (4 == numMatchingDigits) {
            System.out.println("Match all digits: you win $5,000");
        }
        else if (3 == numMatchingDigits) {
            System.out.println("Match three digits: you win $2,000");
        }
        else if (2 == numMatchingDigits) {
            System.out.println("Match two digits: you win $500");
        }
        else if (1 == numMatchingDigits) {
            System.out.println("Match two digit: you win $500");
        }
        else {
            System.out.println("Sorry, no match");
        }
    }
}