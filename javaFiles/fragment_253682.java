String marker = null;
while (true) {
    PageSet<StorageMetadata> set = blobStore.list(containerName,
            new ListContainerOptions().afterMarker(marker);
    for (StorageMetadata sm : set) {
        if (sm.getCreateDate() < expiryDate) {
            blobStore.removeBlob(containerName, sm.getName());
        }
    }
    marker = set.getNextMarker();
    if (marker == null) {
        break;
    }
}