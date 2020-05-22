private Stage stage;

// Called automatically once for init objects
@Override
public void show() { 
    stage = new Stage();

    stage.setDebugAll(true); // Set outlines for Stage elements for easy debug

    BitmapFont white = new BitmapFont(Gdx.files.internal("new.fnt"), false);
    LabelStyle headingStyle = new LabelStyle(white, Color.WHITE);
    Label gameoverstring = new Label("game ovaaaa!", headingStyle);

    stage.addActor(gameoverstring);

}

// Called every frame so try to put no object creation in it
@Override
public void render(float delta) { 
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    stage.draw();

    stage.act(delta);

}