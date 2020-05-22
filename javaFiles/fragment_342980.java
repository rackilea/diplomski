public BufferedImage combine(final BufferedImage image1, final BufferedImage image2, final BufferedImage image3){
    final BufferedImage image = new BufferedImage(image1.getWidth(), image1.getHeight(), image1.getType());
    for(int x = 0; x < image.getWidth(); x++){
        for(int y = 0; y < image.getHeight(); y++){
            final int red = new Color(image1.getRGB(x, y)).getRed();
            final int green = new Color(image2.getRGB(x, y)).getGreen();
            final int blue = new Color(image3.getRGB(x, y)).getBlue();
            final int rgb = new Color(red, green, blue).getRGB();
            image.setRGB(x, y, rgb);
        }
    }
    return image;
}