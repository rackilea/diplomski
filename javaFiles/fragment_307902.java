getRootPane().setGlassPane(new JComponent() {
    public void paintComponent(Graphics g) {
        g.setColor(new Color(0, 0, 0, 100));
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
});