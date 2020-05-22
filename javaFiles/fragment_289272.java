enum Dir {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public Dir opposite() {
        switch(this) {
            case NORTH: return Dir.SOUTH;
            case SOUTH: return Dir.NORTH;
            case EAST: return Dir.WEST;
            case WEST: return Dir.EAST;
            default: throw new IllegalStateException("This should never happen: " + this + " has no opposite.");
        }
    }
}