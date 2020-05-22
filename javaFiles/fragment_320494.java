BufferedImage scaleImage(BufferedImage sourceImage, int scaledWidth) {
   float scale = scaledWidth / (float) sourceImage.getWidth();
   int scaledHeight = (int) (sourceImage.getHeight() * scale);
   Image scaledImage = sourceImage.getScaledInstance(
      scaledWidth, 
      scaledHeight, 
      Image.SCALE_AREA_AVERAGING
   );

   BufferedImage bufferedImage = new BufferedImage(
      scaledImage.getWidth(null), 
      scaledImage.getHeight(null), 
      BufferedImage.TYPE_INT_RGB
   );
   Graphics g = bufferedImage.createGraphics();
   g.drawImage(scaledImage, 0, 0, null);
   g.dispose();

   return bufferedImage;
}