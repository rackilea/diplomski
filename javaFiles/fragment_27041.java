ByteArrayOutputStream os = new ByteArrayOutputStream();
ImageWriter writer = (ImageWriter) ImageIO.getImageWritersByFormatName("jpeg").next();

ImageWriteParam param = writer.getDefaultWriteParam();
param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
param.setCompressionQuality(0.2f); // Change this, float between 0.0 and 1.0

writer.setOutput(ImageIO.createImageOutputStream(os));
writer.write(null, new IIOImage(image, null, null), param);
writer.dispose();