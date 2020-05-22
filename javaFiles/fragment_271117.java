public class MoveableSpaceship implements Moveable  
{  
    private Spaceship ship;

    public MoveableSpaceship(Spaceship s)
    {
       ship = s;
    } 

    @Override
    public void drive()
    {
       ship.warp();
    }
}