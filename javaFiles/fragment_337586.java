enum Direction {
    NORTH, EAST, SOUTH, WEST;

    static {
        (SOUTH.oppositeDirection = NORTH).oppositeDirection = SOUTH;
        (WEST.oppositeDirection = EAST).oppositeDirection = WEST;
    }

    private Direction oppositeDirection;

    public Direction getOppositeDirection() {
        return oppositeDirection;
    }
}