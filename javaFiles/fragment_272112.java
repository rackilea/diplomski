table.addListener(new InputListener() {

    Vector2 vec = new Vector2();

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        table.localToParentCoordinates(vec.set(x, y));
        return true;
    }

    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        float oldTouchY = vec.y;
        table.localToParentCoordinates(vec.set(x, y));
        table.moveBy(0f, vec.y - oldTouchY);
    }
});