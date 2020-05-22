@Override
protected void paintComponent (Graphics g) {
    System.err.println("paintComponent()");
    super.paintComponent(g);
    g.fillPolygon(shape);
}