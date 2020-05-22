public class World
{
     Territory territory1, territory2, territory3, territory4;

    public World()
    {
       Player player1 = new Player();
       Player player2 = new Player();

       territory1 = new Territory(0, 0);
       territory2 = new Territory(1, 0);
       territory3 = new Territory(0, 1);
       territory4 = new Territory(1, 1);     
    }

    public toString()
    {
        if( territory1 != null)
            System.out.println(territory1.posX);
    }
}