@Override
public void create() {
    stage = new Stage(new ScreenViewport());
    batch = new SpriteBatch();
    skin = new Skin(Gdx.files.internal("shadeui/uiskin.json"));

    // create a root table, sized to our stage, and add it to the stage
    Table root = new Table();
    root.setBackground(skin.getDrawable("dialogRed"));
    root.setSize(stage.getWidth(), stage.getHeight());
    stage.addActor(root);

    // now create our menu, bottom-aligned, filled to width, and add it to root
    Table menu = new Table();
    menu.setBackground(skin.getDrawable("dialogDim"));
    root.add(menu).expand().bottom().fillX().height(50);

    // add additional labels to the menu
    menu.defaults().expandX().center().uniformX().uniformX();
    menu.add(new Label("HP", skin));
    menu.add(new Label("MP", skin));
    menu.add(new Label("My Name", skin));
    menu.add(new Label("My Class", skin));
}

@Override
public void render() {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    batch.begin();
    stage.draw();
    batch.end();
}