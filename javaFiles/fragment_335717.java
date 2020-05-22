try(ImageInputStream in = ImageIO.createImageInputStream(resourceFile)){
    final Iterator<ImageReader> readers = ImageIO.getImageReaders(in);
    if (readers.hasNext()) {
        ImageReader reader = readers.next();
        try {
            reader.setInput(in);
            return new Dimension(reader.getWidth(0), reader.getHeight(0));
        } finally {
            reader.dispose();
        }
    }
}