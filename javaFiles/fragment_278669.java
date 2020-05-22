public void duplicateImage(File inFile,File outFile) throws IOException {
      BufferedImage img = new BufferedImage(width,2*height,BufferedImage.TYPE_3BYTE_BGR);
      BufferedImage image = ImageIO.read(inFile)
      for (int i = 0; i < width; i++) {
       for (int j = 0; j < 2*height; j++) {
        int pixel = image.getRGB(i, j%height);
        img.setRGB(i, j, pixel);
       }
       }
       ImageIO.write(img,"jpg",outFile);
     }