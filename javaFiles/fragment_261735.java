// Get a writer for JPEG.
ImageWriter iw = ImageIO.getImageWritersByFormatName("jpeg").next();
iw.setOutput(new FileImageOutputStream(outputFile));

// Set the compression quality to 0.9f.
ImageWriteParam iwParam = iw.getDefaultWriteParam();
iwParam.setCompressionQuality(0.9f);

// Write image
iw.write(null, new IIOImage(imageToWrite, null, null), iwParam);