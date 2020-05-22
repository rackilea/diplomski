@Override
public void render(float delta) {
    float widthScale = Gdx.graphics.getWidth() / originalWidth;
    float heightScale = Gdx.graphics.getHeight() / originalHeight;
    spriteBatch.begin();
    spriteBatch.draw(background, 0, 0, background.getWidth() * widthScale, background.getHeight() * heightScale);
    spriteBatch.draw(newGameButton, 180, 380, newGameButton.getWidth() * widthScale, newGameButton.getHeight() * heightScale);
    spriteBatch.draw(highScoresButton, 180, 340, highScoresButton.getWidth() * widthScale, highScoresButton.getHeight() * heightScale);
    spriteBatch.draw(exitGameButton, 180, 300, exitGameButton.getWidth() * widthScale, exitGameButton.getHeight() * heightScale);

    spriteBatch.end();

}