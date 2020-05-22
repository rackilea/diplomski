byte[] data;
BufferedImage image;

try (ImageInputStream inputStream = ImageIO.createImageInputStream(new ByteArrayInputStream(data))) {
    Iterator<ImageReader> readers = ImageIO.getImageReaders(inputStream);

    // Try reading the data, using each reader until we succeed (or have no more readers)
    while (readers.hasNext()) {
        ImageReader reader = readers.next();

        try {
            reader.setInput(inputStream);
            image = reader.read(0);
            break; // Image is now correctly decoded
        }
        catch (Exception e) {
            // TODO: Log exception?
            e.printStackTrace();

            // Reading failed, try the next Reader
            inputStream.seek(0);
        }
        finally {
            reader.dispose();
        }
    }
}