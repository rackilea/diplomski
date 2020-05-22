public boolean touchDragged(int screenX, int screenY, int pointer) {
    if (pointer < 20) {
                player1.setTouchPosition(new Vector3(Gdx.input.getX(pointer), Gdx.input.getY(pointer), 0));
                camera.unproject(player1.getTouchPosition());        }
    return true;
}