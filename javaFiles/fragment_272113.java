table.addListener(new InputListener() {

    float touchY;

    @Override
    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        touchY = y;
        return true;
    }

    @Override
    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        // since you move your table along with pointer, your touchY will be the same in table's local coordinates
        float deltaY = y - touchY;
        table.moveBy(0f, deltaY);
    }
});