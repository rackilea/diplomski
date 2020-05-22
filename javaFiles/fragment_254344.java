public class HangmanBeta {
private static final boolean testingMode = true;

public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    keyboard.useDelimiter("\\n");
    while (true) {
        System.out.println("Enter your difficulty: Easy (e), Intermediate (i), or Hard (h)");
        String diff = keyboard.next();
        int amountOfSpaces = 0;
        String response = "";
        String guess = "";
        String newGuess = "";
        String letterInput = "";

        int count = 0;
        String newWord = "loops";//RandomWord.newWord();

        int guesses = 0;
        for (int i = 0; i < newWord.length(); i++) {
            guess = newWord.replaceAll("[^#]", "-");
        }
        if ((diff.equalsIgnoreCase("e")) || (diff.equalsIgnoreCase("i")) || (diff.equalsIgnoreCase("h"))) {
            if (diff.equalsIgnoreCase("e")) {
                guesses = 15;
            }
            if (diff.equalsIgnoreCase("i")) {
                guesses = 12;
            }
            if (diff.equalsIgnoreCase("h")) {
                guesses = 15;
            }
            if (testingMode == true) {
                System.out.println("The secret word is:" + " " + newWord);
            }
            System.out.println("The word is:" + " " + guess);

            while (!newWord.equalsIgnoreCase(guess))
                innerloop:
                        {
                            while (true) {
                                System.out.println("Please enter the letter you want to guess");
                                letterInput = keyboard.next();
                                letterInput = Character.toString(letterInput.charAt(0));

                                if (!Character.isLetter(letterInput.charAt(0))) {
                                    System.out.println("Your input is not valid, try again");
                                    break;
                                }
                                if (letterInput.equalsIgnoreCase("solve")) {
                                    System.out.println("Please solve the answer:");
                                    String userSolve = keyboard.next();
                                    if (!userSolve.equalsIgnoreCase(newWord)) {
                                        System.out.println("That is not the secret word");
                                        guesses = guesses - 1;
                                        System.out.println("Guesses remaining: " + guesses);
                                    } else {
                                        System.out.println("You win!");
                                        System.out.println("You have guessed the word! Congratulations");
                                        System.out.println("Would you like to play again? Yes(y) or No (n)");
                                        response = keyboard.next();
                                        if (response.equalsIgnoreCase("n")) {
                                            System.exit(0);
                                        }
                                        if (response.equalsIgnoreCase("y")) {
                                            continue;
                                        }

                                    }
                                }
                                System.out.println("Please enter the spaces you want to check (separated by spaces)");
                                String spaces = keyboard.next();
                                amountOfSpaces = spaces.length();
                                if (diff.equalsIgnoreCase("e")) {
                                    if (amountOfSpaces != 7) {
                                        System.out.println("Your input is not valid, try again");
                                        break innerloop;
                                    }

                                }
                                if (diff.equalsIgnoreCase("i")) {
                                    if (amountOfSpaces != 5) {
                                        System.out.println("Your input is not valid, try again");
                                        break innerloop;
                                    }
                                }

                                if (diff.equalsIgnoreCase("h")) {
                                    if (amountOfSpaces != 3) {
                                        System.out.println("Your input is not valid, try again");
                                        break innerloop;
                                    }
                                }

                                int numSpacesLeft = spaces.split("\\s").length;

                                for (String a : spaces.split("\\s")) {


                                    int x = Integer.valueOf(a);
                                    if (x > guess.length()) {
                                        System.out.println("Your input is not valid, try again");
                                        break innerloop;
                                    }

                                    if (Character.toLowerCase(newWord.charAt(x)) == letterInput.charAt(0)) {
                                        //System.out.println("Guess is correct for position " + x);
                                        guess = guess.substring(0, x) + letterInput + guess.substring(x + 1, guess.length());

                                    }

                                    numSpacesLeft--;

                                    if (Character.toLowerCase(newWord.charAt(x)) != letterInput.charAt(0)) {

                                        if (numSpacesLeft == 0) {
                                            guesses = guesses - 1;
                                            System.out.println("Your letter was not found in spaces you provided");
                                            System.out.println("Guesses Remaining: " + guesses);
                                        }
                                    }

                                    if (guesses == 0) {
                                        System.out.println("You have failed to guess the word....:(");
                                        System.out.print("Would you like to play again? Yes(y) or No(n)");
                                        response = keyboard.next();
                                        if (response.equalsIgnoreCase("n")) {
                                            System.exit(0);
                                        }
                                        if (response.equalsIgnoreCase("y")) {
                                            continue;
                                        }
                                    }
                                }
                            }

                            if (newWord.equalsIgnoreCase(guess)) {
                                System.out.println("You win!");
                                System.out.println("You have guessed the word! Congratulations");
                                System.out.println("Would you like to play again? Yes(y) or No (n)");
                                response = keyboard.next();
                                if (response.equalsIgnoreCase("n")) {
                                    System.exit(0);
                                }
                                if (response.equalsIgnoreCase("y")) {
                                    continue;
                                }

                            }
                        }
            System.out.println("Your Guess is in the word");
        }
        if (guesses == guesses - 1) {


            //System.out.print(spaces.split("\\s").length);
            //System.out.println("Your Guess is in the word");
            //System.out.println();
            //System.out.println("Updated word " + guess);
            //System.out.println("Guesses Remaining: " + guesses);
        }
    }
}

}