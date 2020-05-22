public void paintComponent(Graphics g) {
    super.paintComponent(g);

    g2d = (Graphics2D) g;
    g2d.drawImage(sourceImage, op, 0, 0);
}