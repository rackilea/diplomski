@Override
public boolean pan(float x, float y, float deltaX, float deltaY) {
    camera.translate(deltaX, -deltaY, 0);
    camera.update();
    return false;
}