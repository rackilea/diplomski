@Override
protected void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g.create();
    g2.rotate(angle, getPreferredSize().width / 2, getPreferredSize().height / 2);
    // g2.drawString(super.getText(), 0, 0);
    // setBounds(getX(), getY());

    // ***** This is a kludge and needs to be calculated better ****
    Rectangle clipBounds = g2.getClipBounds();
    int extraBounds = 10;
    int x = clipBounds.x - extraBounds;
    int y = clipBounds.y - extraBounds;
    int width = clipBounds.width + 2 * extraBounds;
    int height = clipBounds.height + 2 * extraBounds;
    g2.setClip(x, y, width, height);
    // ***** end kludge

    super.paintComponent(g2);
    g2.dispose();
}