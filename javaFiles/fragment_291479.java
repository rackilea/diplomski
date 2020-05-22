enum TileType { ... };

interface Tile {
    String getName();
    int getCode();
    TileType getType();
}

class StandardTile implements Tile {
    ...
}

enum FonpaiTile implements Tile {
    TON, NAN, SHA, PEI;
    public TileType getType() { return TileType.FONPAI; }
}

enum SangenTile implements Tile {
    HAK, HAT, CHN;
    public TileType getType() { return TileType.SANGEN; }
}

class TileSet {
    private final Set<Tile> tiles = new HashSet<>();
    private int id = 0;
    public TileSet() {
        // create all the standard and special tiles and add to set
    }
}

class Pool {
    private final List<Tile> tiles = new ArrayList<>();

    public Pool() {
        TileSet tileSet = new TileSet();
        for (int i = 0; i < 4; i++)
            tiles.addAll(tileSet);
        ...
        Collections.shuffle(tiles);
    }

    public Tile takeTile() {
        return tiles.remove(0);
    }

    public boolean isEmpty() {
        return tiles.isEmpty();
    }
}