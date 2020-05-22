public void checkBounds(Circle circle) {
    int height = getHeight();
    Rectangle bounds = circle.getBounds();

    if (bounds.y + bounds.height > height) {
        circle.move(0, -(height) + bounds.height);
    }
}