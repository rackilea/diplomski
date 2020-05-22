public class GameState {
     private int planets;

      public void addPlanets(int amount)
      {
       this.planets += amount;
      }   
   }


    public class Ship {

      private int planetsAmount;

      public void addPlanets(GameState gameState)
      {
        gameState.addPlanets(planetsAmount);
      }
    }