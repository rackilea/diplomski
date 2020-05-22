float marioSpeed = 10.0f; // 10 pixels per second.
float marioX;
float marioY;

public void render() {
   if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) 
      marioX -= Gdx.graphics.getDeltaTime() * marioSpeed;
   if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) 
      marioX += Gdx.graphics.getDeltaTime() * marioSpeed;
   if(Gdx.input.isKeyPressed(Keys.DPAD_UP)) 
      marioY += Gdx.graphics.getDeltaTime() * marioSpeed;
   if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) 
      marioY -= Gdx.graphics.getDeltaTime() * marioSpeed;

   Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
   batch.begin();
   batch.draw(mario, (int)marioX, (int)marioY);
   batch.end();
}