public class MyGdxTest extends Game implements InputProcessor {

    private SpriteBatch batch;
    private ExtendViewport extendViewport;
    private OrthographicCamera cam;

    private float w=20;
    private float h=22;

    private World world;
    private Box2DDebugRenderer debugRenderer;

    private Array<Body> array;
    private Vector3 vector3;

    @Override
    public void create() {

        cam=new OrthographicCamera();
        extendViewport=new ExtendViewport(w,h,cam);

        batch =new SpriteBatch();
        Gdx.input.setInputProcessor(this);

        world=new World(new Vector2(0,-9.8f),true);
        array=new Array<Body>();
        debugRenderer=new Box2DDebugRenderer();
        vector3=new Vector3();

        BodyDef bodyDef=new BodyDef();
        bodyDef.type= BodyDef.BodyType.StaticBody;
        bodyDef.position.set(0,0);
        Body body=world.createBody(bodyDef);

        ChainShape chainShape=new ChainShape();
        chainShape.createChain(new float[]{1,1,55,1});

        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.shape=chainShape;
        fixtureDef.restitution=.5f;
        body.createFixture(fixtureDef);
        chainShape.dispose();
    }

    @Override
    public void render() {
        super.render();

        Gdx.gl.glClearColor(0,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(1/60f,6,2);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();

        world.getBodies(array);
        for (Body body:array){
            if(body.getUserData()!=null) {
                Sprite sprite = (Sprite) body.getUserData();
                sprite.setPosition(body.getPosition().x-sprite.getWidth()/2, body.getPosition().y-sprite.getHeight()/2);
                sprite.setRotation(body.getAngle()*MathUtils.radDeg);
                sprite.draw(batch);
            }
        }
        batch.end();
        debugRenderer.render(world,cam.combined);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width,height);
        extendViewport.update(width,height);
        cam.position.x = w /2;
        cam.position.y = h/2;
        cam.update();
    }

    private void createPhysicsObject(float x,float y){

        float sizeX=2,sizeY=2;
        BodyDef bodyDef=new BodyDef();
        bodyDef.position.set(x,y);
        bodyDef.type= BodyDef.BodyType.DynamicBody;

        Body body=world.createBody(bodyDef);

        PolygonShape polygonShape=new PolygonShape();
        polygonShape.setAsBox(sizeX,sizeY);
        FixtureDef fixtureDef=new FixtureDef();
        fixtureDef.shape=polygonShape;
        fixtureDef.restitution=.2f;
        fixtureDef.density=2;

        body.createFixture(fixtureDef);
        body.setFixedRotation(false);
        polygonShape.dispose();


        Sprite sprite=new Sprite(new Texture("badlogic.jpg"));
        sprite.setSize(2*sizeX,2*sizeY);
        sprite.setPosition(x-sprite.getWidth()/2,y-sprite.getHeight()/2);
        sprite.setOrigin(sizeX,sizeY);

        body.setUserData(sprite);
    }

    @Override
    public void dispose() {
        batch.dispose();
        debugRenderer.dispose();
        world.dispose();
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

        vector3.set(screenX,screenY,0);
        Vector3 position=cam.unproject(vector3);
        createPhysicsObject(vector3.x,vector3.y);

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