@Override
public void render(float delta) {
    Gdx.gl.glClearColor(0, 0, 0, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    game.batch.begin();

    game.batch.draw(playerDotImage, playerDotRectangle.x, playerDotRectangle.y, playerDotRectangle.width, playerDotRectangle.height);

    for (int i = 0; i < gameDotMap.size; i++) {
        game.batch.draw(gameDotMap.getValueAt(i), gameDotMap.getKeyAt(i).x, gameDotMap.getKeyAt(i).y);
    }

    game.batch.end();

    // check if we need to create a new dot
    if (TimeUtils.nanoTime() - lastDotTime > 1000000000) {
        populateDots();
    }

    for (Iterator<ObjectMap.Entry<Rectangle, Texture>> iter = gameDotMap.iterator(); iter.hasNext();) {
        ObjectMap.Entry<Rectangle, Texture> entry = iter.next();
        Rectangle dot = entry.key;
        int gameSpeed = 400;
        int xSpeed = calXSpeed(gameSpeed);
        dot.y = dot.y - gameSpeed * Gdx.graphics.getDeltaTime();

        if (dot.x < width / 2 - 64 / 2) {
            dot.x = dot.x + xSpeed * Gdx.graphics.getDeltaTime();
        } else if (dot.x > width / 2 - 64 / 2) {
            dot.x = dot.x - xSpeed * Gdx.graphics.getDeltaTime();
        }
        if (dot.y + 64 < 0) {
            iter.remove();
        }
        if (dot.overlaps(playerDotRectangle)) {
            //this is where I am trying to remove the map object on collision
            iter.remove();
        }
    }
}