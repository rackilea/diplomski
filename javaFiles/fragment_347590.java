public class ExampleGame extends InputAdapter {

    SpriteBatch batch;
    Color crownColor;

    public ExampleGame() {
        batch = new SpriteBatch();
        crownColor = Color.WHITE;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        crownColor = Color.RED;
        return false;
    }

    public void render(TextureRegion player, TextureRegion crown) {
        batch.begin();
        batch.setColor(Color.WHITE); // Else player will be affected by crownColor too
        batch.draw(player, 0, 0);
        batch.setColor(crownColor);
        batch.draw(crown, 0, 0);
        batch.end();
    }
}