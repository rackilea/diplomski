//convert byte array back to BufferedImage
InputStream in = new ByteArrayInputStream(imageInByte);
BufferedImage bImageFromConvert = ImageIO.read(in);

ImageIO.write(bImageFromConvert, "jpg", 
         new File("c:\\image\\mypic_new.jpg"));