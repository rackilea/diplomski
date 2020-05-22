ImageWriter writer = null;
    Iterator<ImageWriter> iwi = ImageIO.getImageWritersByFormatName("jpg");
    if (!iwi.hasNext())
        return;
    writer = (ImageWriter) iwi.next();
    ImageWriteParam iwp = writer.getDefaultWriteParam();
    iwp.setCompressionMode(ImageWriteParam.MODE_EXPLICIT) ;
    iwp.setCompressionQuality(compressionQuality);
    writer.setOutput(...);
    writer.write(null, image, iwp);