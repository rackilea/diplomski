public class Counter {

    private int playerOneWins;
    private int playerTwoWins;
    private int ties;

    public void check(Dice player1, Dice player2) {

        if (player1.compareTo(player2) > 0) {
            System.out.println("Player 1 wins!!");
            playerOneWins++;
        } else if (player2.compareTo(player1) > 0) {
            System.out.println("Player 2 wins!!");
            playerTwoWins++;
        } else {
            System.out.println("It's a tie...");
            ties++;
        }
    }

    public void showResults() {
        System.out.println();
        System.out.println("Player 1 Total wins: " + playerOneWins);
        System.out.println("Player 2 Total wins: " + playerTwoWins);
        System.out.println("Total Ties: " + ties);
        System.out.close();
    }
}