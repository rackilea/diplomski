public class Snippet extends ApplicationAdapter {

    ShapeRenderer renderer;
    OrthographicCamera camera;

    Ball ball = new Ball();

    @Override
    public void create () {
        renderer = new ShapeRenderer();
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        ball.update(Gdx.graphics.getDeltaTime());

        renderer.setProjectionMatrix(camera.combined);
        renderer.begin(ShapeType.Line);
        renderer.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        renderer.circle(ball.position.x, ball.position.y, ball.radius);

        // Show the travel path of the ball if we were to click at the current location.
        if (Gdx.app.getType() == ApplicationType.Desktop || Gdx.app.getType() == ApplicationType.WebGL) {
            renderer.setColor(0.2f, 0.2f, 0.2f, 1.0f);
            renderer.line(ball.position.x, ball.position.y, Gdx.input.getX(), Gdx.graphics.getHeight()- Gdx.input.getY());          
        }
        renderer.end();

        if (Gdx.input.justTouched()) {
            // Invert the the y to accommodate difference in coordinate systems
            ball.shootToward(Gdx.input.getX(), Gdx.graphics.getHeight()- Gdx.input.getY());
        }
    }

    class Ball {

        public float speedMax = 350;

        public float radius = 10;
        public Vector2 position = new Vector2();
        public Vector2 velocity = new Vector2();

        /** Shoot the ball toward the designated position */
        public void shootToward(float targetX, float targetY) {
            /*
             * Get the normalized direction vector from our position to the target. Then scale that value to our desired speed. In
             * this particular example, we are using the distance of the target from the current position to determine how fast we
             * will shoot the ball, and limiting to a maximum speed. We will apply velocity in the update method.
             */
            velocity.set(targetX - position.x, targetY - position.y).nor().scl(Math.min(position.dst(targetX, targetY), speedMax));
        }

        public void update(float deltaTime) {
            position.add(velocity.x * deltaTime, velocity.y * deltaTime);
            velocity.scl(1 - (0.98f * deltaTime)); // Linear dampening, otherwise the ball will keep going at the original velocity forever
        }

    }

    public static void main(String[] args) {
        new LwjglApplication(new Snippet2());
    }

}