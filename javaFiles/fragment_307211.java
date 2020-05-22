@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g.create();

    g2d.setColor(Color.RED);
    g2d.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
    g2d.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);

    g2d.setColor(Color.BLACK);
    int x = (getWidth() - image.getWidth()) / 2;
    int y = (getHeight() - image.getHeight()) / 2;
    AffineTransform at = new AffineTransform();
    at.setToRotation(getAngle(), x + (image.getWidth() / 2), y + (image.getHeight() / 2));
    at.translate(x, y);
    g2d.setTransform(at);
    g2d.drawImage(image, 0, 0, this);
    g2d.dispose();
}