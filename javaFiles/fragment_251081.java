try (ImageInputStream input = ImageIO.createImageInputStream(source)) {

        // Find potential readers
        Iterator<ImageReader> readers = ImageIO.getImageReaders(input);

        // For each reader: try to read
        while (readers != null && readers.hasNext()) {
            ImageReader reader = readers.next();
            try {
                reader.setInput(input);
                BufferedImage image = reader.read(0);
                return image;
            } catch (IIOException e) {
                // Try next reader, ignore.
            } catch (Exception e) {
                // Unexpected exception. do not continue
                throw e;
            } finally {
                // Close reader resources
                reader.dispose();
            }
        }

        // Couldn't resize with any of the readers
        throw new IIOException("Unable to resize image");
    }