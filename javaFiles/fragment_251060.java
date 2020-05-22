private class ColorPanel extends JPanel {
    private Color color = Color.BLUE;

    public void setColor(Color color) {
        this.color = color;
        repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public Dimension getPreferredSize() {
        return new Dimension(150, 150);
    }
}