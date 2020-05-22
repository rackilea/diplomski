TIFFImageWriterSpi spi = new TIFFImageWriterSpi();
ImageWriter writer = spi.createWriterInstance();
ImageWriteParam param = writer.getDefaultWriteParam();
param.setCompressionMode(ImageWriteParam.MODE_DISABLED);

ImageOutputStream ios = ImageIO.createImageOutputStream(new File("output.tif"));
writer.setOutput(ios);
writer.write(null, new IIOImage(bmp, null, null), param);