try (InputStream input = uploadedFile.getInputStream()) {
    String mimeType = Magic.getMagicMatch(input, false).getMimeType();
    if (mimeType.startsWith("image/")) {
        // It's an image.
    } else {
        // It's not an image.
    }
}