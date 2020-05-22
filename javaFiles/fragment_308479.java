public class Guess {
    public static int MAXIMUM = 100;

    public static void main(String[] args) {
        boolean play = true; // true while we want to play, gets false when we quit
        int totalGuesses = 0; // how many guesses at all
        int bestGame = Integer.MAX_VALUE; // the best games gets the maximum value. so every game would be better than this
        int totalGames = 0; // how many games played in total
        Scanner console = new Scanner(System.in); // our scanner which we pass

        gameIntroduction(); // show the instructions

        while (play) { // while we want to play
            int lastGame = playGame(console); // run playGame(console) which returns the guesses needed in that round
            totalGames++; // We played a game, so we increase our counter

            if (lastGame < bestGame) bestGame = lastGame; // if we needed less guesses last round than in our best game we have a new bestgame

            totalGuesses += lastGame; // our last guesses are added to totalGuesses (totalGuesses += lastGame equals totalGuesses + totalGuesses + lastGame)

            play = checkPlayNextGame(console); // play saves if we want to play another round or not, whats "calculated" and returned by checkPlayNextGame(console)
        }

        getGameResults(totalGames, totalGuesses, bestGame); // print our final results when we are done
    }

    // Prints the instructions for the game.
    public static void gameIntroduction() {
        System.out.println("This process allows you to play a guessing game.");
        System.out.println("I will think of a number between 1 and");
        System.out.println(MAXIMUM + " and will allow you to guess until");
        System.out.println("you get it. For each guess, I will tell you");
        System.out.println("whether the right answer is higher or lower");
        System.out.println("than your guess.");
        System.out.println();
    }

    // Takes the user's input and compares it to a randomly selected number.
    public static int playGame(Scanner console) {
        int guesses = 0; // how many guesses we needed
        int guess = 0; // make it zero, so it cant be automatic correct
        System.out.println("I'm thinking of  a number between 1 and " + MAXIMUM + "...");
        int randomNumber = (int) (Math.random() * MAXIMUM + 1); // make our random number. we don't need the Random class with its object for that task

        while (guess != randomNumber) { // while the guess isnt the random number we ask for new guesses
            System.out.print("Your guess? ");
            guess = console.nextInt(); // read the guess
            guesses++; // increase guesses

            // check if the guess is lower or higher than the number
            if (randomNumber < guess) 
                System.out.println("It's lower.");
            else if (randomNumber > guess) 
                System.out.println("It's higher.");
        }

        System.out.println("You got it right in " + guesses + " guesses"); // Say how much guesses we needed
        return guesses; // this round is over, we return the number of guesses needed
    }

    public static boolean checkPlayNextGame(Scanner console) {
        // check if we want to play another round
        System.out.print("Do you want to play again? ");
        String input = (console.next()).toUpperCase(); // read the input
        if (input.contains("Y")) return true; // if the input contains Y return true: we want play another round (hint: don't use contains. use equals("yes") for example)
        else return false; // otherwise return false: we finished and dont want to play another round
    }

    // Prints the results of the game, in terms of the total number
    // of games, total guesses, average guesses per game and best game.
    public static void getGameResults(int totalGames, int totalGuesses, int bestGame) {
        // here you passed the total guesses twice. that isnt necessary.
        System.out.println("Overall results:");
        System.out.println("\ttotal games   = " + totalGames);
        System.out.println("\ttotal guesses = " + totalGuesses);
        System.out.println("\tguesses/games = " + ((double) (totalGuesses) / (double) (totalGames))); // cast the numbers to double to get a double result. not the best way, but it works :D
        System.out.println("\tbest game     = " + bestGame);
    }
}