@Override
public void draw(SpriteBatch spriteBatch) {
    stateTime += Gdx.graphics.getDeltaTime();
    TextureRegion currentFrame =  animation.getKeyFrame(stateTime, true);
    spriteBatch.draw(currentFrame, body.getTransform().getPosition().x, body.getTransform().getPosition().y);
}