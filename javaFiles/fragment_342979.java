public BufferedImage combine(final BufferedImage image1, final BufferedImage image2, final BufferedImage image3){
    final BufferedImage image = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
    for(int x = 0; x < image.getWidth(); x++)
        for(int y = 0; y < image.getHeight(); y++)
            image.setRGB(x, y, new Color(new Color(image1.getRGB(x, y)).getRed(), new Color(image2.getRGB(x, y)).getGreen(), new Color(image3.getRGB(x, y)).getBlue()).getRGB());
    return image;
}