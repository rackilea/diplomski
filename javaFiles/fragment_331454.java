private void openImage() {
   java.io.File f = showFileDialog(true);
   try {   
      sourceImage = ImageIO.read(f);
      sourceImage = new BufferedImage(sourceImage.getWidth(), sourceImage.getHeight(), BufferedImage.TYPE_INT_ARGB);
      Graphics2D g = sourceImage.createGraphics();
      g.drawImage(ImageIO.read(f), 0, 0, null);
      g.dispose();
      JLabel l = new JLabel(new ImageIcon(sourceImage));
      originalPane.getViewport().add(l);
      this.validate();
      } catch(Exception ex) { ex.printStackTrace(); }
   }

private void embedMessage(BufferedImage img, String mess) {
   int messageLength = mess.length();

   int imageWidth = img.getWidth(), imageHeight = img.getHeight(),
      imageSize = imageWidth * imageHeight;
   if(messageLength * 2 + 8 > imageSize) {
      JOptionPane.showMessageDialog(this, "Message is too long for the chosen image",
         "Message too long!", JOptionPane.ERROR_MESSAGE);
      return;
      }
   embedInteger(img, messageLength, 0);

   byte b[] = mess.getBytes();
   for(int i=0; i<b.length; i++)
      embedByte(img, b[i], i*2+8);
   }

private void embedInteger(BufferedImage img, int n, int start) {
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   for(int i=startX; i<maxX && count<32; i++) {
      for(int j=startY; j<maxY && count<32; j++) {
         int rgb = img.getRGB(i, j), bit = getBitValue(n, count);
         rgb = setBitValue(rgb, 0, bit);
         bit = getBitValue(n, count+1); rgb = setBitValue(rgb, 8, bit);
         bit = getBitValue(n, count+2); rgb = setBitValue(rgb, 16, bit);
         bit = getBitValue(n, count+3); rgb = setBitValue(rgb, 24, bit);
         img.setRGB(i, j, rgb); 
         count = count+4;
         }
      }
   }

private void embedByte(BufferedImage img, byte b, int start) {
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   for(int i=startX; i<maxX && count<8; i++) {
      for(int j=startY; j<maxY && count<8; j++) {
         if(j==maxY-1){
            startY = 0;
            }
         int rgb = img.getRGB(i, j), bit = getBitValue(b, count);
         rgb = setBitValue(rgb, 0, bit);
         bit = getBitValue(b, count+1); rgb = setBitValue(rgb, 8, bit);
         bit = getBitValue(b, count+2); rgb = setBitValue(rgb, 16, bit);
         bit = getBitValue(b, count+3); rgb = setBitValue(rgb, 24, bit);
         img.setRGB(i, j, rgb);
         count = count+4;
         }
      }
   }