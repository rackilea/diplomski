private ArrayList<Line> lines = new ArrayList<Line>();
private Line tmpLine = null;

public DrawPanel() {
    initComponents();
}

public void drawTemporaryLine(int x1, int y1, int x2, int y2) {
    tmpLine = new Line(x1, y1, x2, y2);
}

public void setTemporaryLine(int x1, int y1, int x2, int y2) {
    lines.add(new Line(x1, y1, x2, y2));
}

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(3));
    g2d.setColor(Color.black);
    for (Line l : lines) {
        g2d.drawLine(l.getX1(), l.getY1(), l.getX2(), l.getY2());
    }
    if (tmpLine != null) {
        g2d.drawLine(tmpLine.getX1(), tmpLine.getY1(), tmpLine.getX2(), tmpLine.getY2());
    }
}