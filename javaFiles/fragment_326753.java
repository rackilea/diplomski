public class Game{
    private HillClimber hc = new HillClimber(); //Create the instance and sets ballWeight to 200
    public static void main(String[] args){
         playGame();
         hc.incrementBallWeight(); //ballWeight == 201

         playAnotherGame()
         hc.incrementBallWeight(); //ballWeight == 202 -> Always the same instance of HillClimber (hc)
         .
         .
         . 

    }
}