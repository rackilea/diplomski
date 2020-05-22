public class PlanetResources implements Observer
{
    //Amount of resources of each type
    private int metallicMicrolattice;
    private int energy;
    private int carbyne;
    private int deuterium; 
    private int vibranium;

    //...

    public void update(SpaceShipFactory.SpaceShipConstrctedArgs e)
    {
        // update resources, don't case about ship model
        this.metallicMicrolattice -= e.metalConsumed;
        this.energy -= e.energyConsumed;
        // ...
    }
}