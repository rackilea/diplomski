enum Direction {
    NORTH, EAST, SOUTH, WEST;

    public Direction rotate(boolean clockwise) {
        int nextIndex = ordinal() + (clockwise ? 1 : 3);
        return values()[nextIndex % 4];
    }
}