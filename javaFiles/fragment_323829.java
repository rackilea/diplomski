public void paint(GraphicsContext g, double x, double y) {
    if (image == null) return;

    ColorAdjust colorAdjust = new ColorAdjust();
    colorAdjust.setBrightness(0.1);
    g.setEffect(colorAdjust);

    g.drawImage(image, x, y);
}