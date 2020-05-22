BufferedImage image = ...; // Your input image

ImageWriter writer = ImageIO.getImageWritersByFormatName("TIFF").next(); // Assuming a TIFF plugin is installed

try (ImageOutputStream out = ImageIO.createImageOutputStream(...)) { // Your output file or stream
    writer.setOutput(out);

    ImageWriteParam param = writer.getDefaultWriteParam();
    param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
    param.setCompressionType("PackBits");

    writer.write(null, new IIOImage(image, null, null), param);
}

writer.dispose();