v.setOnTouchListener(new OnTouchListener() {

    @Override
    public boolean onTouch(View v, MotionEvent me) {
        touchX = (int) me.getX();
        touchY = (int) me.getY();
        for (Sprite sprite : enemiesList) {
            sprite.checkTouch(touchX, touchY);
        }
        return true;
    }
});