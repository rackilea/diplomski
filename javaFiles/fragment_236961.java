public class StationedShip implements Observer
{
    //Ships of each type
    private ArrayList<SpaceShip> lightFighters;
    private ArrayList<SpaceShip> heavyFighters;
    //...

    public void update(SpaceShipFactory.SpaceShipConstrctedArgs e)
    {
        // create ships in hangar, don't case about resources consumed
        if (evt.shipModel == SpaceShipFactory.SpaceshipModel.LightFighter)
        {
            lightFighters.add(new SpaceShipLightFighter(...));
        }
        else if (evt.shipModel == SpaceShipFactory.SpaceshipModel.LightFighter)
        {
            heavyFighters.add(new SpaceShipHeavyFighter(...));
        }
        // ...
    }
}