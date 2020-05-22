private void setClipViewport(Region region) {
    int width = region.getWidth();
    int height = region.getHeight();

    Rectangle rect = new Rectangle(0, 0, width, height);
    Circle circ = new Circle(width / 2, height / 2, Math.min(width, height) / 2);

    Shape clip = Shape.subtract(rect, circ);

    region.setClip(clip);
}