private BlobKey saveToBlobstore(String contentType, String imageName, byte[] imageData) throws IOException {
    // Get a file service
    FileService fileService = FileServiceFactory.getFileService();

    // Create a new Blob file and set the name to contain ref to UserImage
    AppEngineFile file = fileService.createNewBlobFile(contentType, imageName);

    // Open a channel to write to it
    FileWriteChannel writeChannel = fileService.openWriteChannel(file, true);

    writeChannel.write(ByteBuffer.wrap(imageData));
    writeChannel.closeFinally();

    // return the BlobKey
    return fileService.getBlobKey(file);
}