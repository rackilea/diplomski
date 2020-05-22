try (ImageInputStream content = ImageIO.createImageInputStream(this.getClass().getResourceAsStream(path))) {
    ImageReader reader = ImageIO.getImageReaders(input).next(); // Assumes PNGImageReader is always there
    reader.setInput(input);

    IIOMetadata metadata = reader.getImageMetadata(0);
    Node nativeTree = metadata.getAsTree(metadata.getNativeMetadataFormatName());
    Node standardTree = metadata.getAsTree(IIOMetadataFormatImpl.standardMetadataFormatName);

    // ... Get color space information as needed using DOM traversal
}