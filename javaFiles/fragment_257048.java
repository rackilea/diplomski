try {
    sourceImage = ImageIO.read(new File("C:/Users/shane/Dropbox/issue453.jpg"));

    bi = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);

    op = new RescaleOp(.1f, 0, null);
    bi = op.filter(bi, null);

    Graphics2D g = bi.createGraphics();

    g.drawImage(sourceImage, 0, 0, 500, 382, null);
    g.dispose();

} catch (Exception e) {
    e.printStackTrace();
}