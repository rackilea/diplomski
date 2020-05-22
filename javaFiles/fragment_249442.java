public class Player extends Entity { 
    Coord obj;
    public Player(int x, int y) {
        obj = new Coord(x,y);
        System.out.println(“Player is at coordinate “ + obj.getX() + “,” 
        + obj.getY());
    }
}