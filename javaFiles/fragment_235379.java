abstract class Player {
   private String name;
   private boolean myTurn = false;
   protected Game game;

   public Player(String name, Game game) {
      this.name = name;
      this.game = game;
   }

   public abstract void makeMove();

   public boolean isMyTurn() {
      return myTurn;
   }

   public void setMyTurn(boolean myTurn) {
      this.myTurn = myTurn;
   }

   public String getName() {
      return name;
   }

}

class HumanPlayer extends Player {

   public HumanPlayer(String name, Game game) {
      super(name, game);
   }

   @Override
   public void makeMove() {
      // TODO: ask GUI to inform player that it's his turn to move and accept the move

   }


}

class ComputerPlayer extends Player {
   private ChessAi chessAi = new ChessAi();

   public ComputerPlayer(String name, Game game) {
      super(name, game);
   }

   @Override
   public void makeMove() {
      game.move(this, chessAi.calcBestMove());
   }

}