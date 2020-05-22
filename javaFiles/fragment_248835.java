private void uploadToStorage(Storage storage, File uploadFrom, BlobInfo blobInfo) throws IOException {
    // For small files:
    if (uploadFrom.length() < 1_000_000) {
        byte[] bytes = Files.readAllBytes(uploadFrom.toPath());
        storage.create(blobInfo, bytes);
        return;
    }

    // For big files:
    // When content is not available or large (1MB or more) it is recommended to write it in chunks via the blob's channel writer.
    try (WriteChannel writer = storage.writer(blobInfo)) {

        byte[] buffer = new byte[10_240];
        try (InputStream input = Files.newInputStream(uploadFrom.toPath())) {
            int limit;
            while ((limit = input.read(buffer)) >= 0) {
                writer.write(ByteBuffer.wrap(buffer, 0, limit));
            }
        }

    }
}