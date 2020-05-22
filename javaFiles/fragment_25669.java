//Actor class
final float STEP = 1f;

...

@Override
public void act(float delta) {
    super.act(delta);

    if(Gdx.input.isKeyPressed(Keys.W))
        this.setPosition(getX(), getY() + STEP);
    if(Gdx.input.isKeyPressed(Keys.S))
        this.setPosition(getX(), getY() - STEP);
    if(Gdx.input.isKeyPressed(Keys.A))
        this.setPosition(getX() - STEP, getY());
    if(Gdx.input.isKeyPressed(Keys.D))
        this.setPosition(getX() + STEP, getY());
}