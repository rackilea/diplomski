public class Oval extends JPanel {

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(120, 150);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.orange);
        g.fillOval(20, 50, 100, 100);
    }
}