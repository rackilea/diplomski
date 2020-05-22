try (ImageInputStream stream = ImageIO.createImageInputStream(input)) {
    Iterator<ImageReader> readers = ImageIO.getImageReaders(stream);
    if (readers.hasNext()) {
        ImageReader reader = readers.next();
        reader.setInput(stream);

        // Get width/height of first image in file
        // (alternatively, use getNumImages() and loop over all images)
        int w = reader.getWidth(0);
        int h = reader.getHeight(0);

        if (w * h > SANE_MAX_SIZE) {
            // TODO: Handle image too large
        }
    }
}