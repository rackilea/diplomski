yCoordBg1 += BACKGROUND_MOVE_SPEED * Gdx.graphics.getDeltaTime();
yCoordBg2 = yCoordbg1 + yMax;  // We move the background, not the camera
if (yCoordBg1 >= 0) {
    yCoordBg1 = yMax*(-1); yCoordBg2 = 0;
}
batch.begin();
batch.draw(background1, 0, yCoordBg1);
batch.draw(background2, 0, yCoordBg2);
batch.end();