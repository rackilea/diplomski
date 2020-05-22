public static InputStream convertTifToPng(InputStream inputImage)
        throws IOException, InterruptedException {
    IIORegistry registry = IIORegistry.getDefaultInstance();
    registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.tiff.TIFFImageWriterSpi());
    registry.registerServiceProvider(new com.sun.media.imageioimpl.plugins.tiff.TIFFImageReaderSpi());

    BufferedImage image;

    if (inputImage != null) {
        image = ImageIO.read(inputImage);
    } else {
        return null;
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "jpg", baos);
    InputStream outputImage = new ByteArrayInputStream(baos.toByteArray());

    return outputImage;
}