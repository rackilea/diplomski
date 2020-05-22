public static void main(String args[]) {
   String playAgain = "yes";
   ArrayList<Integer> totalGuesses = new ArrayList<>(); // Keep track of total guesses in all rounds
   int round = 1; // Round number
   do {
      // Prints greeting
      System.out.println("Welcome to High Low game.\nPlease enter difficulty level.");
      System.out.println("Level 1: Easy Range [1-10]");
      System.out.println("Level 2: Medium Range [1-100]");
      System.out.println("Level 3: Hard Range [1-1000]");
      System.out.print("\nEnter Level Number: ");

      Scanner scanner = new Scanner(System.in);
      int difficultyLevel = scanner.nextInt();
      // Making sure that user inputs difficulty level within a certain range
      while (!(difficultyLevel > 0 && difficultyLevel <= 3)) {
         System.out.print("Please enter correct difficulty level: ");
         difficultyLevel = scanner.nextInt();
      }
      // Displays selected difficulty level
      System.out.println("Difficulty level is set to " + difficultyLevel + "\n");
      int theNumber = 0;

      if (difficultyLevel == 1) { // This part is copied from your code
         theNumber = (int) (Math.random() * 10) + 1;
      } else if (difficultyLevel == 2) {
         theNumber = (int) (Math.random() * 100) + 1;
      } else if (difficultyLevel == 3) {
         theNumber = (int) (Math.random() * 1000) + 1;
      }

      boolean hasGuessed = false;
      int numberOfGuesses = 0; // keep track of number of guesses in each round
      int guessedNumber;
      ArrayList<Integer> alreadyGuessed = new ArrayList<>();
      while (!hasGuessed) { // While user has not guessed (This while loop is nested in do while)
         System.out.print("Please guess the number: ");
         guessedNumber = scanner.nextInt();
         if (theNumber == guessedNumber) { // If user guesses correctly
            hasGuessed = true;
            numberOfGuesses++;
            System.out.printf("\nCongratulations you have guessed the number on your number %d attempt",
            numberOfGuesses);
            totalGuesses.add(new Integer(numberOfGuesses));
         } else { // If guess is incorrect
            numberOfGuesses++;
            alreadyGuessed.add(new Integer(guessedNumber));
            if (guessedNumber > theNumber) {
               System.out.println("\nSorry but the number you are trying to guess is lower that your guess");
            } else {
               System.out.println("\nSorry but the number you are trying to guess is higher that your guess");
            }
            // Prints already guessed so user doesn't enter same value. You can program so it doesn't accept same number by checking the guessedNumber againstalreadyGuessed
            System.out.println("Already guessed numbers: " + alreadyGuessed.toString());
         }
      }
      // when hasGuessed is true the while loop exits
      System.out.print("\nDo you want to play again? Enter yes or no: ");
      playAgain = scanner.next(); // Asking user if they want another round
      if (playAgain.equalsIgnoreCase("yes")) {
         System.out.println("\nRound " + ++round); //Prints round number plus adds empty line between each round
      }
   } while (playAgain.equalsIgnoreCase("yes"));
   // If player enters anything besides yes it exits do while loop
   double averageGuesses = calculateAverage(totalGuesses); // Calculates average guesses
   System.out.println("\nYour average number of guesses are " + averageGuesses);
}

/*
 * Adds all elements in array and divides it by arraylist size
 */
private static double calculateAverage(ArrayList<Integer> list) {
   Integer sum = 0;
   if (!list.isEmpty()) {
      // Iterate through list and stores each item in a variable (item)
      for (Integer item : list) { 
         sum += item; // short form of sum = sum + item;
      }
      return sum.doubleValue() / list.size();
   }
   return sum;
}