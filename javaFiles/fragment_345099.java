@Override
public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D)g;

    // This line is optional. It makes the edges of the triangle much smoother.
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

    // Give the triangle whatever color you want.
    g2.setColor(Color.BLACK);

    int[] x = new int[3];
    int[] y = new int[3];
    for (int i = 0; i < 3; i++) {
        Point p = points[i];
        x[i] = (int)p.getX();
        y[i] = (int)p.getY();
    }
    // Alternatively use g2.drawPolygon to just draw the outlines
    g2.fillPolygon(x, y, 3);

    g2.dispose();
}