/*
 * Which players turn is it?
 * (true for human player, false for computer)
 */ 
boolean isHumanPlayersTurn = true;
int totalPoints = 0;

Scanner input = new Scanner(System.in);

// the game ending condition
while (totalPoints < 21) {

    // take an action, depending on the players turn
    if (isHumanPlayersTurn) {
        System.out.print("\nEnter a 1, 2, or 3 >> ");
        totalPoints += input.nextInt();
    } else {
        int random = (int) (Math.random() * 3 + 1);
        System.out.println("The computer takes " + random);
        totalPoints += random;
    }

    System.out.println("Total amount is " + totalPoints);

    /*
     * Important part: After each players move, change the players turn, but do NOT
     * do this if the game already ended, since then the other player would have won.
     */
    if (totalPoints < 21) {
        isHumanPlayersTurn = !isHumanPlayersTurn;
    }
}

// now, the player to move is the one who loses
if (isHumanPlayersTurn) {
    System.out.println("You lost! The computer is the victor.");
} else {
    System.out.println("You Win!");
}