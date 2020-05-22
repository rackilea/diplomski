thisImage = thisImage = ... a java.awt.Image from a scanner
if(thisImage!=null){  
  ByteArrayOutputStream baos = new ByteArrayOutputStream();
  ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
  boolean foundWriter = false;
  BufferedImage bimg = new BufferedImage(thisImage.getWidth(null),thisImage.getHeight(null), BufferedImage.TYPE_BYTE_BINARY);
  bimg.createGraphics().drawImage(thisImage, 0, 0, null); 
  for(Iterator<ImageWriter> writerIter = ImageIO.getImageWritersByFormatName("tif"); writerIter.hasNext() && !foundWriter;) {
    foundWriter = true;
    ImageWriter writer = (ImageWriter)writerIter.next();
    writer.setOutput(ios);
    TIFFImageWriteParam writeParam = (TIFFImageWriteParam)writer.getDefaultWriteParam();
    writeParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    writeParam.setCompressionType("CCITT T.6"); 
    writer.prepareWriteSequence(null);
    ImageTypeSpecifier spec = ImageTypeSpecifier.createFromRenderedImage(bimg);
    javax.imageio.metadata.IIOMetadata metadata = writer.getDefaultImageMetadata(spec, writeParam);
    IIOImage iioImage = new IIOImage(bimg, null, metadata);
    writer.writeToSequence(iioImage, writeParam);
    bimg.flush();
    writer.endWriteSequence();
    ios.flush();
    writer.dispose();
    ios.close();
    thisByteArray = baos.toByteArray(); 
    baos.close();
  }
}