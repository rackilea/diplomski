public void render(SpriteBatch sb) {
    sb.setProjectionMatrix(gameCam.combined);
    sb.begin();

    sb.draw(bg,gameCam.position.x - (gameCam.viewportWidth /2),0);

    sb.draw(groud,groundpos1.x,groundpos1.y);
    sb.draw(groud,groundpos2.x,groundpos2.y);


    sb.setProjectionMatrix(guiCam.combined);
    String s = Integer.toString(SCORE);
    String h = Integer.toString(highscore);
    font.draw(sb, s, font.getSpaceWidth(), guiCam.viewportHeight / 2 - 39);
    high.draw(sb, h, guiCam.viewportWidth /2, guiCam.viewportHeight / 2 - 39);
    sb.end();
}