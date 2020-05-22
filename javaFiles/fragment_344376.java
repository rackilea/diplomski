@Component
public class RpgGameClient {

     private GameService gameService;

     public RpgGameClient(GameService gameService){
       this.gameService = gameService;
     }

     public void runGame() {
        gameService.createNewGame();
     }

}