private Stage stage;
    private Texture texture;

    @Override
    public void create() {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        texture = new Texture(Gdx.files.internal("data/libgdx.png"));
        TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);          

        com.badlogic.gdx.scenes.scene2d.ui.Image actor = new com.badlogic.gdx.scenes.scene2d.ui.Image(region);
        stage.addActor(actor);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }