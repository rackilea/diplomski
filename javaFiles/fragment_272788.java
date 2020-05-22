private BufferedImage renderedImage;

public void triggerEvent(int width, int height) {
    this.renderedImage = new BufferedImage(width, height, TYPE_INT_ARGB);
    Graphics2D g = this.renderedImage.createGraphics();

    // Paint things on g.
}

@Override
public void paintComponent(Graphics g) {
    g.drawImage(this.renderedImage, 0, 0, this);
}