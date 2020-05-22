enum Direction {
    NORTH, SOUTH, EAST, WEST;
}

class Position {
    private final int x;
    private final int y;

    public static Stream<Position> getAllPositions();
    public Stream<Position> getNeighbours();
    public Optional<Position> positionInDirection(Direction direction);

    // make sure you implement equals and hashCode
}

class Map {
    private final Map<Position, Tile> tiles = new HashMap<>();

    public Map() {
        Position.getAllPositions().forEach(pos -> tiles.put(pos, new Tile());
    }

    public Tile getTile(Position position) {
        return tiles.get(position);
    }
}