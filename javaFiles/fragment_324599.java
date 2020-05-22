@Override
public boolean touchDragged(int screenX, int screenY, int pointer) {
    Vector3 v = new Vector3(screenX, screenY, 0);
    v = camera.unproject(v);
    myFish.onClick(v.x, v.y);
    return true;
}