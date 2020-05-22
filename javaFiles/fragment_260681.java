public void draw(Graphics myBuffer) {
    if (visible) {
        myBuffer.setColor(getColor());
        myBuffer.fillRect(getX(), getY(), getXWidth(), getYWidth());
    }
}