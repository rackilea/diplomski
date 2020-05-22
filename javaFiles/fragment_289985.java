public static class HorizontalSplit extends JPanel {

    public HorizontalSplit() {
        setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(0, 3);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        Graphics2D g2d = (Graphics2D) g.create();
        int y = (getHeight() - 3) / 2;
        BasicStroke stroke = new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
        g2d.setStroke(stroke);
        g2d.drawLine(0, y, getWidth(), y);
        g2d.dispose();
    }

}