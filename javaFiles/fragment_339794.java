protected void paintComponent(Graphics g) {
    if (point != null) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setComposite(AlphaComposite.getInstance(
            AlphaComposite.SRC_OVER, 0.3f));
        g2d.setColor(Color.yellow);
        g2d.fillOval(point.x, point.y, 120, 60);
    }
}