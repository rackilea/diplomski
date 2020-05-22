class OvalComponent extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillOval(20, 20, 20, 20);
    }
}