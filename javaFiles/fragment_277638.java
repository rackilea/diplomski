File input = new File("digital_image_processing.jpg");
  BufferedImage image = ImageIO.read(input);

  File compressedImageFile = new File("compress.jpg");  
  OutputStream os = new FileOutputStream(compressedImageFile);

  Iterator<ImageWriter>writers = ImageIO.getImageWritersByFormatName("jpg");
  ImageWriter writer = (ImageWriter) writers.next();

  ImageOutputStream ios = ImageIO.createImageOutputStream(os);
  writer.setOutput(ios);

  ImageWriteParam param = writer.getDefaultWriteParam();
  // Check if canWriteCompressed is true
  if(param.canWriteCompressed()) {
     param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
     param.setCompressionQuality(0.05f);
  }
  // End of check
  writer.write(null, new IIOImage(image, null, null), param);