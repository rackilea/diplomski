@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g;
    for (Rectangle2D rect: rectangles) {
        g2.fill(rect);
    }
}