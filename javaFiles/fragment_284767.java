public BufferedImage resizeImage(Image originalImage, int newD) throws IOException {
    BufferedImage resizedImage = new BufferedImage(newD, newD,
            BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = resizedImage.createGraphics();
    g.drawImage(originalImage, 0, 0, newD, newD, null);
    g.dispose();
    return resizedImage;
}