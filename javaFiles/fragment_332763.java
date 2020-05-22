@Override
public boolean touchDragged(int screenX, int screenY, int pointer) {
myKame.onSwipe(screenX, screenY, pointer);
return true;
}

@Override
public boolean touchDragged(int screenX, int screenY, int button) {
myKame.onSwipe(screenX, screenY, pointer);
return true;
}