IIOMetadata metadata = imageReader.getImageMetadata(imageNo);
if (metadata.isStandardFormatSupported()) { // true for all bundled formats
    IIOMetadataNode root = (IIOMetadataNode) imageMetadata.getAsTree("javax_imageio_1.0");

    // Get either (as pseudo-xpath):
    // /Chroma/NumChannels[@value], which is just number of channels, 3 for RGB
    // /Data/BitsPerSample[@value], bits per sample, typically 8,8,8 for 24 bit RGB
}