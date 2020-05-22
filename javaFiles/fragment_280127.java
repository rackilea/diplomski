@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g.create();

    int xCenter = getWidth() / 2;
    int yCenter = getHeight() / 2;
    int radius = (int) (Math.min(getWidth(), getHeight()) * 0.4);

    g2d.setTransform(AffineTransform.getRotateInstance(Math.toRadians(angle), xCenter, yCenter));

    int x = xCenter - radius;
    int y = yCenter - radius;

    g2d.fillArc(x, y, 2 * radius, 2 * radius, 0, 30);
    g2d.fillArc(x, y, 2 * radius, 2 * radius, 90, 30);
    g2d.fillArc(x, y, 2 * radius, 2 * radius, 180, 30);
    g2d.fillArc(x, y, 2 * radius, 2 * radius, 270, 30);
    g2d.dispose();
}