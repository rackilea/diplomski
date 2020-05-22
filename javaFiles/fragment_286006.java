public class Players {
    private String player;
    private int x, y; // <---
    private boolean turn;
    ...
    public Players(String player, int x, int y, boolean turn){
        this.player = player;
        this.x = x;
        this.y = y;
        this.turn = turn;
    }
    ...
}