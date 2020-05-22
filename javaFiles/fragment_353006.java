Color color = new Color(Color.WHITE);
ColorAction colorAction = new ColorAction();

public MyGame() {
    colorAction.setColor(color);
    colorAction.setDuration(2);
    colorAction.setEndColor(Color.RED);
}

public void render(float delta) {
    Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    colorAction.act(delta);
}