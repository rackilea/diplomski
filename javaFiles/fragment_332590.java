public class ScrollPaneTest extends ApplicationAdapter {
    private Stage stage;
    private Table container;

    @Override
    public void create () {
        stage = new Stage();
        Skin skin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));
        Gdx.input.setInputProcessor(stage);

        container = new Table();
        stage.addActor(container);
        container.setFillParent(true);

        Table table = new Table();

        final ScrollPane scroll = new ScrollPane(table, skin);
        scroll.setScrollingDisabled(true,false);

        table.pad(10).defaults().expandX().space(4);
        for (int i = 0; i < 100; i++) {
            table.row();

            Label label=new Label(i + ". Publish your games on Windows, Mac, Linux, Android, iOS, BlackBerry and HTML5, all with the same code base.", skin);
            label.setAlignment(Align.center);
            label.setWrap(true);
            table.add(label).width(Gdx.graphics.getWidth());
        }

        container.add(scroll).expand().fill();
    }

    @Override
    public void render () {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
    }

    @Override
    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose () {
        stage.dispose();
    }
}