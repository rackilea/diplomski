Scanner scanner = new Scanner(System.in); // create a new scanner
    System.out.print("Welcome to my guessing game! "
        + "Would you like to play (Y/N)? ");
yesOrNoAnswer = scanner.nextLine().charAt(0); // reading the first character from the next line

if(yesOrNoAnswer == 'Y') {
    System.out.print("\n\nGuess the number (between 1 and 10): ");
    while(AnswerIsCorrect == false) {
        guess = Integer.parseInt(scanner.nextLine()); // get an int from the next line

        if(guess == correctAnswer) {
            AnswerIsCorrect = true;
        }
        else {
            System.out.print("\nYou guessed wrong! Please try again: ");
        }
    }
    System.out.print("You guessed correct! Congratulations!"
            + "\n\nPress any key to exit the program . . .");
    scanner.nextLine();
}