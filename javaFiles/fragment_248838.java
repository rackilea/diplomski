public class Client {
   private final Game game;

   @Inject
   public Client(Game game) {
      this.game = game; 
   }   

   ... 
}