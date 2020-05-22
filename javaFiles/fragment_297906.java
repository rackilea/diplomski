public abstract class AbstractScreen implements Screen {
    protected final Game game;

    protected InputMultiplexer multiInputProcessor;
    protected ScreenInputHandler screenInputHandler;

    protected Stage uiStage;
    protected Skin uiSkin;

    public AbstractScreen(Game game) {
        this.game = game;
        this.uiStage = new Stage();
        this.uiSkin = new Skin();

        this.screenInputHandler = new ScreenInputHandler(game);
        this.multiInputProcessor = new InputMultiplexer();

        multiInputProcessor.addProcessor(uiStage);
        multiInputProcessor.addProcessor(screenInputHandler);

        Gdx.input.setInputProcessor(multiInputProcessor);
    }

    private static NinePatch processNinePatchFile(String fname) {
        final Texture t = new Texture(Gdx.files.internal(fname));
        final int width = t.getWidth() - 2;
        final int height = t.getHeight() - 2;
        return new NinePatch(new TextureRegion(t, 1, 1, width, height), 3, 3, 3, 3);
    }

    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        uiStage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        uiStage.draw();
        Table.drawDebug(uiStage);
    }

    @Override
    public void resize (int width, int height) {
    }

    @Override
    public void show() {
    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        uiStage.dispose();
        uiSkin.dispose();
    }
}