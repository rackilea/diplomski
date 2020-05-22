class MyPanel extends JPanel {
    // Background image. Initialize appropriately.
    Image backgroundImage;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw background image each time the panel is repainted.
        g.drawImage(backgroundImage, 0, 0, null);
    }
}