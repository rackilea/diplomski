@Override
public boolean touchUp(int screenX, int screenY, int pointer, int button) {
    myBird.setLeftMove(false);
    myBird.setRightMove(false);
    return true;
}