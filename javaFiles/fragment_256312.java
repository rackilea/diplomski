class SuperPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ...
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(..., ...);
    }
}