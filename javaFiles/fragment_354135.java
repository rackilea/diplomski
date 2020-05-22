public abstract class Tile {
    public void paintTile() {
        ...
    }
}

...

public class PlayerTile extends Tile {
    @Override
    public void paintTile() {
        super.paintTile();
        paintPlayer();
    }

    public void paintPlayer() {
        ...
    }
}

...

public class View {
    private List<Tile> tiles;

    public void paintGame() {
        ...
        for (Tile tile : tiles) {
            tile.paintTile();
        }
        ...
    } 
}