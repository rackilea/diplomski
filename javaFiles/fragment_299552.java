public enum Direction {
    NORTH, EAST, SOUTH, WEST;

    // cached values to avoid recreating such array each time method is called
    private static final Direction[] VALUES = values();

    public Direction getOppositeDirection() {
        return VALUES[(ordinal() + 2) % 4]; 
    }
}