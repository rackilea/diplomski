public class GdxTest extends ApplicationAdapter {

    OrthographicCamera camera;
    ShapeRenderer shapeRenderer;
    float screenOffset=10,circleRadius=30;

    @Override
    public void create() {

        camera=new OrthographicCamera();
        shapeRenderer=new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(camera.combined);

        shapeRenderer.begin();
        shapeRenderer.setColor(Color.BLACK);
        shapeRenderer.circle(camera.viewportWidth/2,camera.viewportHeight/2,circleRadius);
        shapeRenderer.rect(screenOffset,screenOffset,camera.viewportWidth-2*screenOffset,camera.viewportHeight-2*screenOffset);
        shapeRenderer.line(screenOffset,screenOffset,camera.viewportWidth-screenOffset,camera.viewportHeight-screenOffset);
        shapeRenderer.line(screenOffset,camera.viewportHeight-screenOffset,camera.viewportWidth-screenOffset,screenOffset);
        shapeRenderer.line(screenOffset,camera.viewportHeight/2,camera.viewportWidth-screenOffset,camera.viewportHeight/2);
        shapeRenderer.line(camera.viewportWidth/2,screenOffset,camera.viewportWidth/2,camera.viewportHeight-screenOffset);

        shapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.setToOrtho(false,width,height);
        screenOffset=width<height?width*.04f:height*.04f;
        circleRadius=width<height?width*.075f:height*.075f;
    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
    }
}