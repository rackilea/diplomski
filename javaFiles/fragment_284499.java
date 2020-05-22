public static void splitGif(File file) throws IOException {
    ImageReader reader = ImageIO.getImageReadersBySuffix("gif").next();
    reader.setInput(ImageIO.createImageInputStream(new FileInputStream(file)), false);
    BufferedImage outImage = null;
    Graphics2D g = null;    
    for (int i = 0; i < reader.getNumImages(true); i++) {
         BufferedImage image = reader.read(i);
         if (g == null) {
             BufferedImage outImage = new BufferedImage(image.getWidth(), image.getHeight(),
                     BufferedImage.TYPE_4BYTE_ABGR);
             g = (Graphics2D) outImage.getGraphics();
         }
         g.drawImage(lastImage, 0, 0, null);
         ImageIO.write(outImage, "PNG", new File(i + ".png"));
     }
     if (g != null) {
         g.dispose();
     }
}