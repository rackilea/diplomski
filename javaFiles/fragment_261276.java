public BufferedImage render() {
    Graphics2D g2d = getActorImage().createGraphics();
    g2d.setColor(Color.red);
    g2d.fillOval(x, y, radius, radius);
    g2d.dispose();
    return getActorImage();
}