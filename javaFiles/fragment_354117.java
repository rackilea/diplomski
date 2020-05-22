public void darken(final BufferedImage image){
    for(int x = 0; x < image.getWidth(); x++)
        for(int y = 0; y < image.getHeight(); y++)
            image.setRGB(x, y, new Color(image.getRGB(x, y)).darker().getRGB());
}

public void darken(final BufferedImage image, final int intensity){
    assert intensity >= 0 && intensity <= 255;
    final Graphics g = image.getGraphics();
    g.setColor(new Color(0, 0, 0, intensity));
    g.fillRect(0, 0, image.getWidth(), image.getHeight());
    g.dispose();
}