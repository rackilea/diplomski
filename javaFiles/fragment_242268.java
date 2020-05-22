UploadSession session = this.graphServiceClient
    .me()
    .drive()
    .root
    .itemWithPath("_hamilton.jpg")
    .createUploadSession(new DriveItemUploadableProperties())
    .buildRequest()
    .post();