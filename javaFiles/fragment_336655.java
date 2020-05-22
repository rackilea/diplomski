public BufferedImage createSkelethonizationImage() {
   BufferedImage image = new BufferedImage(width, height);
   Graphics2D g2 = image.createGraphics();

   // Perform your drawing here
   g2.drawLine(...);

   g2.dispose();
   return image;
}