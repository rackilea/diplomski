public class SpaceShipFactory implements Publisher
{
    private ArrayList<Observer> observers;

    public enum SpaceshipModel
    {
      LightFighter, 
      HeavyFighter, 
      StarDestoyer,
      BattleShip,
      DeathStar
    };

    public static class SpaceShipConstructedArgs
    {
        public SpaceshipModel shipModel;
        public int metalConsumed = 0;
        public int energyConsumed = 0;
        public int carbonConsumed = 0;
        //...
    };

    public void notifyObservers(SpaceShipConstrctedArgs e) {
        for(Observer obs : observers) { obs.update(e); }
    }

    public void someMethod() {
        // ...
        SpaceShipConstructedArgs evt = new SpaceShipConstructedArgs();
        evt.shipModel = SpaceshipModel.LightFighter;
        evt.metalConsumed = 100;
        notifyObservers(evt);
        // ...
    }
}