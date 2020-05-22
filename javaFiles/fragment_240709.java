public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String userChoice;
    String playAgain;
    int iterationNumber;

    while (true) {
        iterationNumber = 0;
        do {
            if (iterationNumber == 0) {
                System.out.println("Welcome to Rock, Paper, Scissors Game.");
                System.out.println("Pick R, P, or S.");

            } else {
                System.out.println("Please enter valid letter.");
                System.out.println("Pick R, P, or S.");
            }
            iterationNumber++;
            userChoice = sc.nextLine();
        } while (!userChoice.equalsIgnoreCase("P")
                && !userChoice.equalsIgnoreCase("R")
                && !userChoice.equalsIgnoreCase("S"));
        String compChoice = "";
        int randNum = (int) (Math.random() * 3);
        switch (randNum) {
            case 0:
                compChoice = "R";
                break;
            case 1:
                compChoice = "P";
                break;
            case 2:
                compChoice = "S";
                break;
        }

        System.out.println("The computer entered \"" + compChoice + "\".");

        if (compChoice.equalsIgnoreCase(userChoice)) {
            System.out.println("Draw");
        } else if (userChoice.equalsIgnoreCase("R")
                && compChoice.equalsIgnoreCase("S")
                || userChoice.equalsIgnoreCase("P")
                && compChoice.equalsIgnoreCase("R")
                || userChoice.equalsIgnoreCase("S")
                && compChoice.equalsIgnoreCase("P")) {
            System.out.println("User Wins");
        } else {
            System.out.println("User Loses");
        }

        System.out.print(
                "Do you want to play again? (Y/N)");
        playAgain = sc.nextLine();
        if (playAgain.equalsIgnoreCase("N")) {
            break;
        }
        iterationNumber = 0;
    }
    System.out.println("Thanks for Playing!");
}