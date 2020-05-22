Scanner scanner = new Scanner(System.in); //you only need one

int userInput = 0;
int guesses = 0;
int min = 1;
int max = 100;
int range = max - min + 1;
int randNum = (int)(Math.random() * range) + min;
boolean valid = false;
boolean playAgain = false;

do {
  System.out.println("\nThis program is a guessing game.");
  System.out.println("\nThe computer will pick a random number between 1 and 100.");
  System.out.println("\nYou will try to guess it.");
  System.out.println("\nLet's play!");

  do {
    System.out.println("\nI'm thinking of a number between 1 and 100.");
    do {
      System.out.println("Please enter your guess: ");
      if (scanner.hasNextInt()){
        userInput = scanner.nextInt();
        valid = true;
      }
      else {
        System.out.println("Error: Please enter a whole number.\n");
        scanner.nextLine();
        userInput = -1; //this is important
        valid = false;
      }
    } while(!valid);

    if (userInput == randNum) {
      System.out.println("You got it!");
      System.out.println("It took you " + guesses + " tries");
      valid = true;
    }
    else {
      valid = false; //this is important
      ++guesses;
      if (userInput > randNum) {
        System.out.println("\nToo high!");
      }
      else {
        System.out.println("\nToo Low!");
      }
    }
  } while(!valid);

  do {
    System.out.println("\nDo you want to play again?");
    System.out.println("\nEnter 'Y' if yes and 'N' if no.");
    String play = scanner.nextLine();

    if (play.equalsIgnoreCase("Y")) {
      valid = true;
      playAgain = true;
    }
    else if (play.equalsIgnoreCase("N")) {
      valid = true;
      playAgain= false;
    }
    else {
      valid = false;
      System.out.println("Error: Please answer with 'Y' or 'N'");
    }
  } while(!valid);
} while(playAgain);

scanner.close();