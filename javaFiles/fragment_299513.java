class Game extends JFrame {
    /* Type your variable declarations here */

    // Score of game
    int score = 0;

    // Get board size
    int width = this.gameboard.getWidth();
    int height = this.gameboard.getHeight();

    /** The panel where all of the game's images are rendered */
    GameBoard gameboard = null;