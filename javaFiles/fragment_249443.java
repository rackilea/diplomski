public class Player extends Entity { 
    private Coord coordinates;
    public Player(int x, int y) {
        coordinates = new Coord(x,y);
        System.out.println(“Player is at coordinate “ + obj.getX() + “,” 
        + obj.getY());
    }
    public Coord getCoordinates() {
        return coordinates;
    }
}