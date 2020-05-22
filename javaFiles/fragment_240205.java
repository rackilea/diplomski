public class Command {
   private Game game; //  note it's not initialized here

   // pass Game in via a constructor parameter
   public Command(Game game) {
      this.game = game;   // and set the field with it
   }

   public void changeX() {
      // now you'll be changing the state of the same Game object
      int x = game.getX();
      game.setX(x + 1);
   }