public BufferedImage loadImage(String url) {
    ImageIcon icon = new ImageIcon(url);
    Image image = icon.getImage();

    // Create empty BufferedImage, sized to Image
    BufferedImage buffImage = 
      new BufferedImage(
        image.getWidth(null), 
        image.getHeight(null), 
        BufferedImage.TYPE_INT_ARGB);

    // Draw Image into BufferedImage
    Graphics g = buffImage.getGraphics();
    g.drawImage(image, 0, 0, null);
    return buffImage;
}