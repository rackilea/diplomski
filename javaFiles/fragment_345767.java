public void render(Graphics g) {
    // 1...
    Graphics2D g2d = (Graphics2D) g.create();
    // 2...
    Rectangle r = new Rectangle(0, 0, 32, 32);
    Path2D.Double path = new Path2D.Double();
    path.append(r, false);

    AffineTransform t = new AffineTransform();
    // 3...
    t.translate(x, y);
    // 4...
    t.rotate(rotation, 16, 16);
    path.transform(t);
    g2d.setColor(Color.WHITE);
    g2d.draw(path);
    // 5...
    g2d.dispose();
}