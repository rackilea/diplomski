byte[] picByte = Base64.decodeBase64(pic);
    GcsFileOptions instance = new GcsFileOptions.Builder().mimeType("image/jpeg").build();
    GcsFilename fileName = new GcsFilename("xxx-app.appspot.com", "someName.jpg");
    GcsOutputChannel outputChannel;
    GcsService gcsService = GcsServiceFactory.createGcsService();
    outputChannel = gcsService.createOrReplace(fileName, instance);
    ByteBuffer a = ByteBuffer.wrap(picByte);
    outputChannel.write(a);
    outputChannel.close();