class Circle {
    int x, int y, int width, int height;
    public Circle (int x, int y, int width, int height) {
        ... set em
    }
    public void draw(Graphics g) {
        g.fillOval(x, y, width, height);
    }
}
class DrawingPanel extends JPanel {
    List<Circle> circles = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle circle : circles) {
            circle.draw(g);
        }
    }

    // Dont forget to override public Dimension getPreferredSize()
}