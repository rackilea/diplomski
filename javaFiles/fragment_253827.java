BufferedImage bufferedImage = ImageIO.read(...);

ImageWriter writer = (ImageWriter)ImageIO.getImageWritersByFormatName("jpeg").next();
ImageWriteParam iwp = writer.getDefaultWriteParam();
iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
iwp.setCompressionQuality(...);

File file = new File(...);
FileImageOutputStream output = new FileImageOutputStream(file);
writer.setOutput(output);
IIOImage image = new IIOImage(bufferedImage, null, null);
writer.write(null, image, iwp);
writer.dispose();