public enum SnakePartType {
    LEFT_HEAD, RIGHT_HEAD, DOWN_HEAD, UP_HEAD, BODY
}

public class SnakePart {
    private SnakePartType type;
    private Point location; // You could use separate x/y properties, but Point already does it

    public SnakePart(SnakePartType type, Point location) {
        this.type = type;
        this.location = location;
    }

    // Getters for type and location
}