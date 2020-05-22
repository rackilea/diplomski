public void update(){
    //Update camera position
    cam.position.x = player.getX() + (player.getWidth() / 2);
    cam.position.y = player.getY() + (player.getHeight() / 2);
    //apply all updates to the camera before this the changed position won't apply to the camera
    cam.update();
}

@Override
public void render() {
    //First call the update method we created
    update();

    //Clear the Screen
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

    //Render
    gameMap.render(cam);

    gameMap.getTiledMapRenderer().getBatch().begin();
    player.draw(gameMap.getTiledMapRenderer().getBatch());
    gameMap.getTiledMapRenderer().getBatch().end();
}