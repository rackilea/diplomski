@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.translate(this.getWidth() / 2, this.getHeight() / 2);
    g2d.translate(-image.getWidth(null) / 2, -image.getHeight(null) / 2);
    g2d.drawImage(image, 0, 0, null);
}