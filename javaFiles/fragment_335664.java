@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(blinkState ? getBackground() : currentColor());
    g.drawString(theMessage, messageX, messageY);
}