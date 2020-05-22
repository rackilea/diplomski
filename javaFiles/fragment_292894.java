File file = ...; // May also use OutputStream/InputStream here
List<BufferedImage> images = new ArrayList<>(); // Just add images...

Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("TIFF");

if (!writers.hasNext()) {
    throw new AssertionError("Missing plugin");
}

ImageWriter writer = writers.next();

if (!writer.canWriteSequence()) {
    throw new AssertionError("Plugin doesn't support multi page file");       
}

ImageWriteParam param = writer.getDefaultWriteParam();
param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
param.setCompressionType("JPEG"); // The allowed compression types may vary from plugin to plugin
// The most common values for TIFF, are NONE, LZW, Deflate or Zip, or JPEG

try (ImageOutputStream out = ImageIO.createImageOutputStream(file)) {
    writer.setOutput(out);

    writer.prepareWriteSequence(null); // No stream metadata needed for TIFF

    for (BufferedImage image : images) {
        writer.writeToSequence(new IIOImage(image, null, null), param);
    }

    writer.endWriteSequence();
}

writer.dispose();