class DrawCircle extends JPanel implements MouseListener {
    ArrayList<Point> p = new ArrayList<Point>();

    int width = 0;
    int height = 0;

    public DrawCircle(int width, int height) {
        this.width = width;
        this.height = height;
        addMouseListener(this);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Point point : p) {
            g.fillOval(point.x, point.y, 30, 30);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        p.add(new Point(e.getX(), e.getY()));
        revalidate();
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
}