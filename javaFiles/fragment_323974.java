public class Main {
    public static void main(String[] args) {
        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
        cfg.title = "my-op0-game";
        cfg.useGL20 = false;
        cfg.width = MyOp0Game.MY_APP_WINDOW_WIDTH;
        cfg.height = MyOp0Game.MY_APP_WINDOW_HEIGHT;

        new LwjglApplication(new MyOp0Game(), cfg);
    }
}


public class MyOp0Game extends Game {

    public static int MY_APP_WINDOW_WIDTH = 512;
    public static int MY_APP_WINDOW_HEIGHT = 512;
    public static int MY_WORLD_WIDTH = 2048;
    public static int MY_WORLD_HEIGHT = 2048;
    public static int MY_MINIMAP_WIDTH = 256;
    public static int MY_MINIMAP_HEIGHT = 256;
    public static int MY_MINIMAP_SCALE_FACTOR = MY_WORLD_WIDTH / MY_MINIMAP_WIDTH;
    public static int MY_ORIGINAL_CAMERA_POSITION_X = MY_APP_WINDOW_WIDTH/2;
    public static int MY_ORIGINAL_CAMERA_POSITION_Y = MY_APP_WINDOW_HEIGHT/2;
    public static final String LOG = "MyOp0Game";

    MyScreen0 my_screen_0;

    @Override
    public void create() {

        // allocate screen
        my_screen_0 = new MyScreen0(this);

        // set current screen
        setScreen(my_screen_0);
    }

    @Override
    public void render() {
        super.render();
    }   
}

public class MyScreen0 implements Screen{

    protected final Stage stage0;
    protected final MyOp0Game game;
    protected final MyActor0 actor0_0;
    protected final MyActor0 actor0_1;
    protected final MyActor1 actor1_0;


    public MyScreen0(MyOp0Game game) {

        // link screen to game
        this.game = game;

        // allocate stage; viewport size maps game window size
        this.stage0 = new Stage( Gdx.graphics.getWidth(),Gdx.graphics.getHeight(), true );

        // allocate actor0_0 and add to stage
        this.actor0_0 = new MyActor0();
        this.actor0_0.setPosition(0, 0);
        this.stage0.addActor(this.actor0_0);

        // allocate actor0_1 and add to stage, actor1 is placed next to actor0
        this.actor0_1 = new MyActor0();
        this.actor0_1.setPosition(512, 256);
        this.stage0.addActor(this.actor0_1);

        // allocate actor1_0 and add to stage
        this.actor1_0 = new MyActor1();
        this.actor1_0.setPosition(0, MyOp0Game.MY_APP_WINDOW_HEIGHT - MyOp0Game.MY_MINIMAP_HEIGHT);
        this.stage0.addActor(this.actor1_0);
    }

    @Override
    public void render(float delta) {

        int lvTranslateX = 0;
        int lvTranslateY = 0;

        // the following code clears the screen with the given RGB color (green)
        Gdx.gl.glClearColor( 0f, 1f, 0f, 1f );
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT ); 

        /* check if mouse pressed */
        if (Gdx.input.isTouched())
        {
            //Gdx.app.log( MyOp0Game.LOG, " mouse X = "+ Gdx.input.getX() +
            //                          " Camera.x = " + this.stage0.getCamera().position.x +
            //                          " mouse Y = "+ (MyOp0Game.MY_APP_WINDOW_HEIGHT - Gdx.input.getY()) +
            //                          " Camera.y = " + this.stage0.getCamera().position.y);

            if (Gdx.input.getX() >= MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_X)
            {
                if (this.stage0.getCamera().position.x - MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_X < MyOp0Game.MY_WORLD_WIDTH - MyOp0Game.MY_APP_WINDOW_WIDTH)
                    lvTranslateX = 3;
            }
            else if (Gdx.input.getX() < MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_X)
            {
                if (this.stage0.getCamera().position.x - MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_X > 0)
                    lvTranslateX = -3;
            }

            if (MyOp0Game.MY_APP_WINDOW_HEIGHT - Gdx.input.getY() >= MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_Y)
            {
                if (this.stage0.getCamera().position.y - MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_Y < MyOp0Game.MY_WORLD_HEIGHT - MyOp0Game.MY_APP_WINDOW_HEIGHT)
                    lvTranslateY = 3;
            }
            else if (MyOp0Game.MY_APP_WINDOW_HEIGHT - Gdx.input.getY() < MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_Y)
            {
                if (this.stage0.getCamera().position.y - MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_Y > 0)
                    lvTranslateY = -3;
            }

            if (lvTranslateX != 0 || lvTranslateY != 0)
            {
                // translate stage camera to go from actor0 to actor1
                this.stage0.getCamera().translate(lvTranslateX, lvTranslateY, 0);

                // update actor1_0 (minimap) location to move with camera 
                this.actor1_0.translate(lvTranslateX,lvTranslateY);
            }
        };

        // draw stage -> draw actors
        this.stage0.draw();

    }

    @Override
    public void resize(int width, int height) {
        // TODO Auto-generated method stub

    }

    @Override
    public void show() {
        // not required as no abstract screen for now
        //super.show();
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub

    }

    @Override
    public void pause() {
        // TODO Auto-generated method stub

    }

    @Override
    public void resume() {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        this.stage0.dispose();
    }

}

public class MyActor0 extends Actor {

    SpriteBatch batch;
    public Texture texture;

    public MyActor0() { 
        batch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("data/libgdx_256_256.png"));
    }

    public void draw(SpriteBatch batch, float alpha){
        batch.draw(texture,this.getX(),this.getY());
    }
}

public class MyActor1 extends Actor {

    SpriteBatch batch;
    Texture texture;
    Texture blackMarkerTexture;
    Texture yelloCameraMinimapTexture;

    public MyActor1() {
        this.batch = new SpriteBatch();
        this.texture = new Texture(Gdx.files.internal("data/blueBg_256_256.png"));
        this.blackMarkerTexture = new Texture(Gdx.files.internal("data/blackMarker_32_32.png"));
        this.yelloCameraMinimapTexture = new Texture(Gdx.files.internal("data/yelloCameraMinimap_64_64.png"));
        this.setName("minimap");

    }

    public void draw(SpriteBatch batch, float alpha){

        // draw actor
        batch.draw(texture,this.getX(),this.getY());

        // draw game window in minimap
        batch.draw( this.yelloCameraMinimapTexture, 
                    this.getX() + (this.getStage().getCamera().position.x - MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_X)/MyOp0Game.MY_MINIMAP_SCALE_FACTOR, 
                    this.getY() + (this.getStage().getCamera().position.y - MyOp0Game.MY_ORIGINAL_CAMERA_POSITION_Y)/MyOp0Game.MY_MINIMAP_SCALE_FACTOR);

        // retrieve actors from stage
        Array<Actor> lvActorArray = this.getStage().getActors();
        for ( int lvIdx = 0; lvIdx < lvActorArray.size; lvIdx++ )
        {
            Actor lvActor = lvActorArray.get(lvIdx);
            if (lvActor.getName() != "minimap")
            {
                batch.draw( this.blackMarkerTexture, 
                            this.getX() + (lvActor.getX()/MyOp0Game.MY_MINIMAP_SCALE_FACTOR),
                            this.getY() + (lvActor.getY()/MyOp0Game.MY_MINIMAP_SCALE_FACTOR));
            }
        }
    }

}