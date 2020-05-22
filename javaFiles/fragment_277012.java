public class MyCircleCanvas extends JComponent {
    private void doDrawing(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(150, 150, 150));
        g2d.fillOval(25, 25, 50, 50);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }
}