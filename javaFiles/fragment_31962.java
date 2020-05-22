public static BufferedImage scale(BufferedImage img, int imageType, int dWidth, int dHeight, double fWidth, double fHeight) {
BufferedImage img = null;
if(img != null) {
    img = new BufferedImage(dWidth, dHeight, imageType);
    Graphics2D g = img.createGraphics();
    AffineTransform at = AffineTransform.getScaleInstance(fWidth, fHeight);
    g.drawRenderedImage(img, at);
}
return img;