public interface Tile {
    public void moveLeft(int pixel);
    public int getX();
    public void setX(int pixel);
}

public static void moveTiles(List<Tile> tiles, int speed, int offScreen, int startPos) {
    tiles.add(null);
    for (int idx = 0; tiles.get(idx) != null;) {
        Tile tile = tiles.get(idx);
        tile.moveLeft(speed);
        if (tile.getX() <= offScreen) {
            tile.setX(startPos);
            tiles.add(tiles.remove(idx));
        } else idx++;
    }
    tiles.remove(null);
}