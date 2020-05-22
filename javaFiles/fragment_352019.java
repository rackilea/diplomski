private final BufferedImage image = getImage();
private BufferedImage getImage() {
    try {
        return ImageIO.read(new URL(
            "http://i.imgur.com/kxXhIH1.jpg"));
    } catch (IOException e) {
        e.printStackTrace(System.err);
    }
    return null;
}
…
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(image,
        textPt.x - image.getWidth() / 2,
        textPt.y - image.getHeight() / 2, this);
}