public interface Tile {
    public void moveLeft(int pixel);
    public void moveRight(int pixel);
    public int getX();
}

public static void main(String[] args) {
    int speedX = 20;
    List<Tile> tiles = getMovingTiles();
    for (Tile tile : tiles) tile.moveLeft(speedX);
    while (tiles.get(0).getX() <= -60) {
        Tile tile = tiles.remove(0);
        tile.moveRight(840);
        tiles.add(tile);
    }
}

private static List<Tile> getMovingTiles() {
    throw new UnsupportedOperationException("not yet implemented");
}