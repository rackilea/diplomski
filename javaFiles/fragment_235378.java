public class Game {
   private Player whitePlayer;
   private Player blackPlayer;
   private Player turn;
   private Board board = new Board(); // non-GUI logical board
   private Gui gui; // the Swing GUI that displays all

   public Game(String humanPlayerName, boolean humanWhite) {
      if (humanWhite) {
         whitePlayer = new HumanPlayer(humanPlayerName, this);
         blackPlayer = new ComputerPlayer("Computer", this);
      } else {
         whitePlayer = new ComputerPlayer("Computer", this);
         blackPlayer = new HumanPlayer(humanPlayerName, this);
      }
   }

   public void start() {
      whitePlayer.setMyTurn(true); // tell white player to move
   }

   public void move(Player playerMakingMove, Move move) {

      // only respond if the right player is making the move
      if (turn == playerMakingMove) {
         // check if its a valid move
         // if so, tell GUI to make move
         // check if game over

         turn.setMyTurn(false); // current player's turn is over
         turn = (turn == blackPlayer) ? whitePlayer : blackPlayer; // swap players
         turn.setMyTurn(true); // tell other player, it's his turn

         turn.makeMove(); // *** added
      } else {
         // send message that it's not their turn to move
      }
   }
}