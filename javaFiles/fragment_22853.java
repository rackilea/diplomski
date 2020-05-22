public byte[] writeCustomData(BufferedImage buffImg, String key, String value) throws Exception {
    ImageWriter writer = ImageIO.getImageWritersByFormatName("png").next();

    ImageWriteParam writeParam = writer.getDefaultWriteParam();
    ImageTypeSpecifier typeSpecifier = ImageTypeSpecifier.createFromBufferedImageType(BufferedImage.TYPE_INT_RGB);

    //adding metadata
    IIOMetadata metadata = writer.getDefaultImageMetadata(typeSpecifier, writeParam);

    IIOMetadataNode textEntry = new IIOMetadataNode("tEXtEntry");
    textEntry.setAttribute("keyword", key);
    textEntry.setAttribute("value", value);

    IIOMetadataNode text = new IIOMetadataNode("tEXt");
    text.appendChild(textEntry);

    IIOMetadataNode root = new IIOMetadataNode("javax_imageio_png_1.0");
    root.appendChild(text);

    metadata.mergeTree("javax_imageio_png_1.0", root);

    //writing the data
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageOutputStream stream = ImageIO.createImageOutputStream(baos);
    writer.setOutput(stream);
    writer.write(metadata, new IIOImage(buffImg, null, metadata), writeParam);
    stream.close();

    return baos.toByteArray();
}