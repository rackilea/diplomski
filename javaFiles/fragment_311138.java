@Override
public void render(float delta) {

    Gdx.gl.glClearColor(1, 1, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.begin();
    carte();
    elapsedTime+= System.currentTimeMilis()-initialTime;
    if(elapsedTime >= 2000) {
        position = new Vector2(this.mari.x, this.mari.y);
        batch.draw(animation.getKeyFrame(time), position.x, position.y, 64, 64);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        elapsedTime=0;
        initialTime=System.currentTimeMilis();

    }
    batch.end();
}