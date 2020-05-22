public OverlayRenderer()
{
    this.spriteBatch = new SpriteBatch();
    this.loadTextures();
}

public void render(String _message)
{
    this.spriteBatch.begin();
    this.spriteBatch.draw(TEXTURES.UI, 0, 0);
    ....
}