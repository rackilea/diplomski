public class EmptyTile extends TileEntity {

    public EmptyTile(int x, int y, int height, int width, Texture texture) {
        super(x, y, height, width, texture);
        try {
            defaultTexture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("stone.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}