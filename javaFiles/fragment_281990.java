public static class Bar extends JComponent {

    private Bar() {
        setPreferredSize(new Dimension(25, 5));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, 100, 10);
    }
}