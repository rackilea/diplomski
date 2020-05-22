File file = ...; // May also use InputStream here
List<BufferedImage> images = new ArrayList<>();

try (ImageInputStream in = ImageIO.createImageInputStream(file)) {
    Iterator<ImageReader> readers = ImageIO.getImageReaders(in);

    if (!readers.hasNext()) {
        throw new AssertionError("No reader for file " + file);
    }

    ImageReader reader = readers.next();

    reader.setInput(in);

    // It's possible to use reader.getNumImages(true) and a for-loop here.
    // However, for many formats, it is more efficient to just read until there's no more images in the stream.
    try {
        int i = 0;
        while (true) {
            images.add(reader.read(i++));
        }
    }
    catch (IndexOutOfBoundsException expected) {
        // We're done
    }

    reader.dispose();
}