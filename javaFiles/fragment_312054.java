public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    if (screenX < WIDTH_OF_SCREEN / 2) {
        myBird.setLeftMove(true);
    } else {
        myBird.setRightMove(true);
    }
    return true;
}