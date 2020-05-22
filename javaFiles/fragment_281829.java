public class TestGame extends Game implements InputProcessor{

    SpriteBatch spriteBatch;
    Sprite ball;
    Texture ballTex;
    boolean isFired;

    Vector2 gravity;
    private float throwAngle=50;
    private float deltaTime=2;
    private Vector2 initialVelocity;

    @Override
    public void create() {

        spriteBatch=new SpriteBatch();
        ballTex=new Texture("image/ball.png");
        ball=new Sprite(ballTex);
        ball.setSize(50,50);
        ball.setPosition(0,0);

        Gdx.input.setInputProcessor(this);
        gravity=new Vector2(0, -Gdx.graphics.getHeight()*.05f);
        float throwVelocity=Gdx.graphics.getWidth()*.3f;
        initialVelocity=new Vector2((float)(throwVelocity*Math.sin(throwAngle * Math.PI / 180)),(float)(throwVelocity*Math.cos(throwAngle * Math.PI / 180)));
    }

    @Override
    public void render() {
        super.render();

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        updateBall();

        spriteBatch.begin();
        ball.draw(spriteBatch);
        spriteBatch.end();
    }

    private void updateBall(){

        if(isFired){

            float delta=Gdx.graphics.getDeltaTime();
            initialVelocity.x=initialVelocity.x+gravity.x*delta*deltaTime;
            initialVelocity.y=initialVelocity.y+gravity.y*delta*deltaTime;

            ball.setPosition(ball.getX()+initialVelocity.x * delta * deltaTime,ball.getY()+initialVelocity.y * delta * deltaTime);
        }

    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void dispose() {
        super.dispose();
        ballTex.dispose();
        spriteBatch.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        isFired=true;
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}