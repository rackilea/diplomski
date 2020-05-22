public class Position {
    private int x;
    private int y;
    ...
    public Position(Position other) {
        this.x = other.x;
        this.y = other.y;
    }
    ...
}