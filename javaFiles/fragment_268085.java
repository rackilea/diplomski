@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Area area = new Area(new Rectangle(0, 0, getWidth(), getHeight()));
    area.subtract(new Area(new RoundRectangle2D.Float(10, 10, getWidth() - 20, getHeight() - 20, 20, 20)));

    Graphics2D g2d = (Graphics2D) g.create();
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2d.setColor(Color.BLACK);
    g2d.fill(area);
    g2d.dispose();
}