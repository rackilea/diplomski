private void writeToImageFile(String imageFileName) {

   BufferedImage bufImage = ScreenImage.createImage((JComponent) jPanel1);
   try {
       File outFile = new File(imageFileName);
       ImageIO.write(bufImage, "png", outFile);
       System.out.println("wrote image to " + imageFileName);
   } catch (Exception e) {
       System.out.println("writeToImageFile(): " + e.getMessage());
   }
}