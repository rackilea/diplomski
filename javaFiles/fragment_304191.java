int amountOfFrames = 50;
int counter = amountOfFrames; // start from 50 so a new card is drawn right when the program begins

@Override
public void render(float delta) {
    if(counter % amountOfFrames == 0) {
        Gdx.gl.glClearColor(1, 0, 0, 1); // screen cleared
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // screen cleared
        Gdx.graphics.getDeltaTime();
        game.getBatch().begin();
        game.getBatch().draw(spading.spades.random(),0,0); // draws a new card
        game.getBatch().end();
    }
    counter++;
}