...

@Override
public boolean keyDown(int keycode) {
    if (keycode == Keys.RIGHT)
        increaseSpeed();
    return true;
}

@Override
public boolean touchDown(int screenX, int screenY, int pointer, int button) {
    increaseSpeed();
    return true;
}