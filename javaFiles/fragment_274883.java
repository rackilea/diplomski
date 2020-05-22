public class ScrollWheel extends Actor {
    Texture wheelTexture;
    private int scroll = 0;

    public int getScroll() {
        return scroll;
    }
    public void setScroll(int scroll) {
        this.scroll = scroll;
    }

    public ScrollWheel(Texture texture)
    {
        wheelTexture = texture;
        wheelTexture.setWrap(Texture.TextureWrap.Repeat, Texture.TextureWrap.ClampToEdge);

        setWidth(texture.getWidth());
        setHeight(texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);

        batch.draw(wheelTexture, getX(), getY(), scroll, 0,
                wheelTexture.getWidth(), wheelTexture.getHeight());
    }
}