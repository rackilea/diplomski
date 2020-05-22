public enum Direction {
    UP, DOWN, LEFT, RIGHT
}

public class Line {
    private Direction direction;
    private int length;

    public Line(Direction direction, int length) {
        this.direction = direction;
        this.length = length;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getLength() {
        return length;
    }


}