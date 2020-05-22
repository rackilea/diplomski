// Image writer
    ImageWriter imageWriter = (ImageWriter)ImageIO.getImageWritersBySuffix("jpeg").next();
    ImageOutputStream ios = ImageIO.createImageOutputStream(jpegOutputStream);
    imageWriter.setOutput(ios);
    IIOMetadata imageMetaData = imageWriter.getDefaultImageMetadata(new ImageTypeSpecifier(challenge), null);
    imageWriter.write(imageMetaData, new IIOImage(challenge, null, null), null);