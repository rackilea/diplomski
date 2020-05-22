private PipedInputStream inStream;
    inStream = .....


    String fullFileUrl = fileUrl;
    Storage storage = StorageServiceHolder.getStorage();
    BlobId blobId = GCSHelper.uri2blobId(fullFileUrl);

    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
    Blob blob = storage.create(blobInfo, inStream);

    }