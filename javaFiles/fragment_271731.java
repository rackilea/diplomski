try (InputStream input = uploadedFile.getInputStream()) {
    try {
        ImageIO.read(input).toString();
        // It's an image (only BMP, GIF, JPG and PNG are recognized).
    } catch (Exception e) {
        // It's not an image.
    }
}