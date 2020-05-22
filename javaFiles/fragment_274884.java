public class TestScreen implements Screen {
    Stage stage;
    ScrollWheel wheel;

    public TestScreen() {
        stage = new Stage();
        Table t = new Table();
        t.setFillParent(true);
        stage.addActor(t);

        wheel = new ScrollWheel(new Texture("hud/wheel_part.png"));
        wheel.addListener(new DragListener() {
            @Override
            public void drag(InputEvent event, float x, float y, int pointer) {
                super.drag(event, x, y, pointer);
                wheel.setScroll(wheel.getScroll() + (int)getDeltaX());
            }
        });

        t.add(wheel);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(.3f, .36f, .42f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act();
        stage.draw();
    }
    //...Other mandatory screen methods...
}