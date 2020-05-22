public class TicTacToe extends JFrame {
    private int scorePlayer1;
    private int scorePlayer2;
    private boolean initialized;    // default = false

    // Reset the board
    // Reset the markers, etc.
    public void resetGame() {}

    // Check to see if there is a winner
    // If so, announce the winner and return true
    // Otherwise, return false.
    public boolean winCheck() {}

    // Set up frame, buttons, score, etc.
    public void newGame(){
        // Create however many JPanels you need
        // Add it to a single JFrame

        // When you're ready...
        // and this game has not been initialized for the first time.
        // In this example jframe is an instance of JFrame
        if (!this.initialized)
            jframe.setVisible(true);
    }

    // Play the game
    public void play(){
        // For each round,
        // a player chooses where to put their "X" or "O"
        // add scores, etc.

        // Then at the end of each round
        if (this.winCheck())
            this.resetGame();
    }
}