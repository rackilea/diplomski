public class Tile {

public int x;
public int y;

public static Sprite sprite;

public static Tile grass = new GrassTile(Sprite.grass);
public static Tile voidTile = new VoidTile(Sprite.voidSprite);

public Tile(Sprite sprite) {
    Tile.sprite = sprite;
}

public void render(int x, int y, Screen screen) {
}

public boolean solid() {
    return false;
}

}