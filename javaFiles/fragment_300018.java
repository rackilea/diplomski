if (CloudBlockBlob.class == blobItem.getClass()) {
    blob = (CloudBlockBlob)blobItem;
}
else if (CloudPageBlob.class == blobItem.getClass()) {
    blob = (CloudPageBlob)blobItem;
}
else if (CloudAppendBlob.class == blobItem.getClass()) {
    blob = (CloudAppendBlob)blobItem;
}