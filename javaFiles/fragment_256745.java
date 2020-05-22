@Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        camera.position.x += deltaX;
        camera.update();
        return false;
    }