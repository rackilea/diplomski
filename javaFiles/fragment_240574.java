SpriteBatch batch;
Texture img;
boolean isTouchDown;
final Vector3 touchPosition = new Vector3();
OrthographicCamera camera;

@Override
public void create () {
    batch = new SpriteBatch();
    img = new Texture("badlogic.jpg");
    camera = new OrthographicCamera();
    Gdx.input.setInputProcessor(new MyInputProcessor()); // Tell LibGDX what to pass input to
}

@Override 
void resize (int width, int height) {
    // Set the camera's size in relation to screen or window size
    // In a real game you would do something more sophisticated or 
    // use a Viewport class to manage the camera's size to make your 
    // game resolution-independent.
    camera.viewportWidth = width;
    camera.viewportHeight = height;

    camera.update(); // re-calculate the camera's matrices
}

@Override
public void render () {
    Gdx.gl.glClearColor(1, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    batch.setProjectionMatrix(camera.combined); // pass camera's matrices to batch
    batch.begin();

    if (isTouchDown) { // Only draw this while the screen is touched.
        batch.draw(img, touchPosition.x, touchPosition.y);
    }

    batch.end();
}

public class MyInputProcessor implements InputProcessor {
    public boolean touchDown (int x, int y, int pointer, int button) {
        isTouchDown = true;

        touchPosition.set(x, y, 0); // Put screen touch coordinates into vector
        camera.unproject(touchPosition); // Convert the screen coordinates to world coordinates
        return true;
    }

    public boolean touchUp (int screenX, int screenY, int pointer, int button){
        isTouchDown = false;
        return true;
    }

    //... (the rest of the input methods)
}