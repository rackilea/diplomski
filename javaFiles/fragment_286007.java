public class Coordinate {
    public final int x, y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class player {
    ...
    private Coordinate position;
    ...
    public Players(String player, Coordinate position, boolean turn){
        this.player = player;
        this.position = position;
        this.turn = turn;
    }   
    ...
}