public void removeExifMetadata(final File jpegImageFile, final File dst)
        throws IOException, ImageReadException, ImageWriteException {
    OutputStream os = null;
    try {
        os = new FileOutputStream(dst);
        os = new BufferedOutputStream(os);

        new ExifRewriter().removeExifMetadata(jpegImageFile, os);
    } finally {
        if (os != null) {
            try {
                os.close();
            } catch (final IOException e) {

            }
        }
    }
}