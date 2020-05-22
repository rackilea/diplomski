public static void zipFiles(final GcsFilename targetZipFile,
        final GcsFilename... filesToZip) throws IOException {

    Preconditions.checkArgument(targetZipFile != null);
    Preconditions.checkArgument(filesToZip != null);
    Preconditions.checkArgument(filesToZip.length > 0);

    final int fetchSize = 4 * 1024 * 1024;
    final int readSize = 2 * 1024 * 1024;
    GcsOutputChannel outputChannel = null;
    ZipOutputStream zip = null;
    try {
        GcsFileOptions options = new GcsFileOptions.Builder().mimeType(MediaType.ZIP.toString()).build();
        outputChannel = GCS_SERVICE.createOrReplace(targetZipFile, options);
        zip = new ZipOutputStream(Channels.newOutputStream(outputChannel));
        GcsInputChannel readChannel = null;
        for (GcsFilename file : filesToZip) {
            try {
                final GcsFileMetadata meta = GCS_SERVICE.getMetadata(file);
                if (meta == null) {
                    LOGGER.warning(file.toString() + " NOT FOUND. Skipping.");
                    continue;
                }
                //int fileSize = (int) meta.getLength();
                //  LOGGER.fine("adding " + file.toString());
                ZipEntry entry = new ZipEntry(file.getObjectName());
                zip.putNextEntry(entry);
                readChannel = GCS_SERVICE.openPrefetchingReadChannel(file, 0, fetchSize);
                final ByteBuffer buffer = ByteBuffer.allocate(readSize);
                int bytesRead = 0;
                while (bytesRead >= 0) {
                    bytesRead = readChannel.read(buffer);
                    buffer.flip();
                    zip.write(buffer.array(), buffer.position(), buffer.limit());
                    buffer.rewind();
                    buffer.limit(buffer.capacity());
                }       

            } finally {
                zip.closeEntry();
                readChannel.close();
            }
        }
    } finally {
        zip.flush();
        zip.close();
        outputChannel.close();
    }
}