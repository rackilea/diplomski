private void openImage() {
   java.io.File f = showFileDialog(true);
   try {   
      image = ImageIO.read(f);
      image = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);
      Graphics2D g = image.createGraphics();
      g.drawImage(ImageIO.read(f), 0, 0, null);
      g.dispose();
      JLabel l = new JLabel(new ImageIcon(image));
      imagePane.getViewport().add(l);
      this.validate();
      } catch(Exception ex) { ex.printStackTrace(); }
   }

private void decodeMessage() {
   int len = extractInteger(image, 0);
   byte b[] = new byte[len];
   for(int i=0; i<len; i++)
      b[i] = extractByte(image, i*2+8);
   message.setText(new String(b));
   }

private int extractInteger(BufferedImage img, int start) {
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   int length = 0;
   for(int i=startX; i<maxX && count<32; i++) {
      for(int j=startY; j<maxY && count<32; j++) {
         int rgb = img.getRGB(i, j), bit = getBitValue(rgb, 0);
         length = setBitValue(length, count, bit);
     bit = getBitValue(rgb, 8); length = setBitValue(length, count+1, bit);
         bit = getBitValue(rgb, 16); length = setBitValue(length, count+2, bit);
         bit = getBitValue(rgb, 24); length = setBitValue(length, count+3, bit);
         count = count+4;
         }
      }
   return length;
   }

private byte extractByte(BufferedImage img, int start) {
   int maxX = img.getWidth(), maxY = img.getHeight(), 
      startX = start/maxY, startY = start - startX*maxY, count=0;
   byte b = 0;
   for(int i=startX; i<maxX && count<8; i++) {
      for(int j=startY; j<maxY && count<8; j++) {
         if(j==maxY-1){
            startY = 0;
            }
         int rgb = img.getRGB(i, j), bit = getBitValue(rgb, 0);
         b = (byte)setBitValue(b, count, bit);
         bit = getBitValue(rgb, 8); b = (byte)setBitValue(b, count+1, bit);
     bit = getBitValue(rgb, 16); b = (byte)setBitValue(b, count+2, bit);
     bit = getBitValue(rgb, 24); b = (byte)setBitValue(b, count+3, bit);
         count = count+4;
         }
      }
   return b;
   }