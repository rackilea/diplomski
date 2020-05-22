public class StepComponent extends JComponent implements MouseMotionListener {
    private Point point = new Point(0, 0);

    public StepComponent() {
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB), 
                new Point(0, 0), "blank cursor"));
        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = 0, y = 0;
        while (x < getWidth()) { g.drawLine(x, 0, x, getHeight()); x += 10; }
        while (y < getHeight()) { g.drawLine(0, y, getWidth(), y); y += 10; }
        if (point != null)
            g.fillRect(point.x, point.y, 10, 10);
    }
    @Override public void mouseDragged(MouseEvent e) { update(e.getPoint()); }
    @Override public void mouseMoved(MouseEvent e) { update(e.getPoint()); }

    private void update(Point p) {
        Point point = new Point(10 * (p.x / 10), 10 * (p.y / 10));
        if (!this.point.equals(point)) {
            Rectangle changed = new Rectangle(this.point,new Dimension(10,10));
            this.point = point;
            changed.add(new Rectangle(this.point, new Dimension(10, 10)));
            repaint(changed);
        }
    }
}