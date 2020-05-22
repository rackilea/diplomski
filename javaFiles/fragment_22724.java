public class Buffer extends JPanel implements MouseListener {
    ...
    private List<Ellipse2D> ovals = new ArrayList<Ellipse2D>();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for (Ellipse2D oval : ovals)
            g2d.draw(oval);
    }

    public void mouseClicked(MouseEvent e) {
        ovals.add(new Ellipse2D.Double(e.getX(), e.getY(), 10, 10);
        repaint();
    }
}