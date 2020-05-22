private int yOffset = 0;
private int ballSize = radius * 2;

public void moveUp() {
    if (computeY() > 0 - radius) {
        yOffset--;
        repaint();
    }
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawOval(getWidth() / 2 - radius, computeY(), ballSize, ballSize);
}

private int computeY() {
    return (getHeight() / 2 - radius) + yOffset;
}