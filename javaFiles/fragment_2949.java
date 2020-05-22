public class BouncyGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture ball;
    float speedX = 3f;
    float speedY = 3f;
    int x;
    int y;

    @Override
    public void create () {
        batch = new SpriteBatch();
        ball = new Texture("ball.png");
        x = Gdx.graphics.getWidth()/2;
        y = Gdx.graphics.getHeight()/2;
    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //When the ball's x position is on either side of the screen.
        //The width of the sprite is taken into account.
        if (x > Gdx.graphics.getWidth() - ball.getWidth()/2 || x < 0 + ball.getWidth()/2) {
            //Here we flip the speed, so it bonces the other way.
            speedX = -speedX;
        }
        //Same as above, but with on the y-axis.
        if (y > Gdx.graphics.getHeight() - ball.getHeight()/2 || y < 0 + ball.getHeight()/2) {
            speedY = -speedY;
        }

        //Move the ball according to the speed.
        x += speedX;
        y += speedY;

        batch.begin();
        //Draw the ball so the center is at x and y. Normally it would be drawn from the lower left corner.
        batch.draw(ball, x - ball.getWidth()/2, y - ball.getHeight()/2);
        batch.end();
    }
}