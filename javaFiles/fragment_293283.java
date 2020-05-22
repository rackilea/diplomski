class DrawingPanel extends JPanel {
    List<Ellipse2D> circles = new ArrayList<>();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g.create();
        for (Ellipse2D circle : circles) {
            g2.fill(circle);
        }
        g2.dispose();
    }
    // Dont forget to override public Dimension getPreferredSize()
}