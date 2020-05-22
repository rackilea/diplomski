public GreenRect extends JPanel {
    // Existing members 

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        for (BlackRect black_rect : r) {
            black_rect.paint(g2d);
        }

        // Also paint list of moving rectangles here
    }
}