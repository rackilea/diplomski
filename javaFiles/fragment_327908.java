public class WorldRenderer {

private static final float CAMERA_WIDTH = 10f;
private static final float CAMERA_HEIGHT = 7f;

private World world;
private OrthographicCamera cam;

/** for debug rendering **/
ShapeRenderer debugRenderer = new ShapeRenderer();

/** Textures **/
private Texture teeTexture;
private Texture blockTexture;

private SpriteBatch spriteBatch;
private boolean debug = false;
private int width;
private int height;
private float ppuX; // pixels per unit on the X axis
private float ppuY; // pixels per unit on the Y axis

public void setSize (int w, int h) {
    this.width = w;
    this.height = h;
    ppuX = (float)width / CAMERA_WIDTH;
    ppuY = (float)height / CAMERA_HEIGHT;
}

public WorldRenderer(World world, boolean debug) {
    Tee tee = world.getTee();
    this.world = world;
    this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
    this.cam.setToOrtho(false,CAMERA_WIDTH,CAMERA_HEIGHT);
    this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
    this.cam.update();
    this.debug = debug;
    spriteBatch = new SpriteBatch();
    loadTextures();
}

private void loadTextures() {
    teeTexture = new  Texture(Gdx.files.internal("tee/tee.png"));
    blockTexture = new Texture(Gdx.files.internal("world/dreck.png"));
}

public void render() {
    moveCamera(tee.getPosition().x, CAMERA_HEIGHT / 2);
    spriteBatch.setProjectionMatrix(cam.combined);
    spriteBatch.begin();
        drawBlocks();
        drawTee();
    spriteBatch.end();
    //if (debug) drawDebug();
}

public void moveCamera(float x,float y){
    if ((tee.getPosition().x > CAMERA_WIDTH / 2)) {
        cam.position.set(x, y, 0);
        cam.update();
    }

}


private void drawBlocks() {
    for (Block block : world.getBlocks()) {
        spriteBatch.draw(blockTexture, block.getPosition().x, block.getPosition().y, Block.SIZE, Block.SIZE);
    }
}

private void drawTee() {
    Tee tee = world.getTee();
    spriteBatch.draw(teeTexture, tee.getPosition().x, tee.getPosition().y, Tee.SIZE, Tee.SIZE);
}