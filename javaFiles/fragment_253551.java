@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    int x = (this.getWidth() - image.getWidth(null)) / 2;
    int y = (this.getHeight() - image.getHeight(null)) / 2;
    g2d.drawImage(image, x, y, null);
}