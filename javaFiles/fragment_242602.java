@Override
public void render(float delta) {

    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);    
    player.update(delta); // to update the player

    /***
    * This does not have to be set every single frame. Move it to show()
    *
    float hsWidth = holdStart.getWidth();
    float hsHeight = holdStart.getHeight();
    float currentFrameWidth = (float)(screenHeight*0.15);
    float currentFrameHeight = (float)(screenHeight*0.15);
    float holdStartWidth = (float)(screenWidth * 0.75);
    ****************************************************/


    BackgroundSFX.play(); // I am sure you don't need to start playing this every single frame? 60 times a second.

    game.batch.begin();
    game.batch.draw(background,0,0, screenWidth,screenHeight);
    game.batch.draw(player.getCurrentFrame(), player.getBound().x, player.getbound().y, player.getBound().width, player.getBound().height)

    game.batch.draw(holdStart, (screenWidth / 2 - (holdStartWidth / 2)), (float) (screenHeight * 0.5), holdStartWidth, holdStartWidth * (hsHeight / hsWidth));
    game.batch.end();
}