Page<Blob> blobs =
    storage.list(
        bucketName, BlobListOption.currentDirectory(),
        BlobListOption.prefix(directory));

for (Blob blob : blobs.iterateAll()) {
  // do something with the blob
}