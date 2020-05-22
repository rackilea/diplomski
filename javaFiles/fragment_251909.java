public class GameStage InputProcessor {
    private Stage stage;
    private InputMultiplexer input;
    private World world;
    private Player player;
    private BitmapFont font;

    private Box2DDebugRenderer renderer;

    public GameStage(Viewport viewport) {
        stage = new Stage(viewport);
        font = new BitmapFont();
        setUpWorld();
        input = new InputMultiplexer();
        input.addProcessor(this);
        input.addProcessor(stage);
    }

    public void setUpWorld() {
        world = WorldUtils.createWorld();
        player = new Player(WorldUtils.createPlayer(world));
        stage.addActor(player)
    }

    @Override
    public void draw() {
        stage.draw();

        getBatch().begin();
        font.draw(getBatch(), "Position: X=" + player.getX() + " Y=" + player.getY(), 200, 50);
        getBatch().end();
    }

    @Override
    public void act(float delta) {
        stage.act(delta);
        world.step(1 / 300f, 6, 2);
    }

    public World getWorld() {
        return this.world;
    }

    public Player getPlayer() {
        return this.player;
    }

    public InputAdapter getInput(){
        return this.input;
    }

    public Stage getStage(){
        return this stage;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        player.move();
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return true;
    }
}