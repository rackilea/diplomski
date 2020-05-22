@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    for (RandomShape shape : shapes) {
        shape.paint(g2d);
    }
    g2d.dispose();
}