public String uploadFile(){

        String bucket_name = "BUCKET_NAME";
        String file_name = "PATH/TO/WHERE/THE/FILE/WILL/BE/UPLOADED/FILE_NAME.xml"

        Storage storage = StorageOptions.getDefaultInstance().getService();
        BlobId blobId = BlobId.of(bucket_name, file_name);
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
        Blob blob = storage.create(blobInfo, readFile().getBytes(UTF_8));
}