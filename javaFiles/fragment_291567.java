public BufferedImage filter(BufferedImage src) {
    BufferedImage convertedImage = new BufferedImage(src.getWidth(), src.getHeight(), BufferedImage.TYPE_BYTE_INDEXED);
    for (int x = 0; x < src.getWidth(); x++) {
        for (int y = 0; y < src.getHeight(); y++) {
            convertedImage.setRGB(x, y, src.getRGB(x, y));
        }
    }
    return convertedImage;
}