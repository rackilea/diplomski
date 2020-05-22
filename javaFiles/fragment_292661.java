public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException {

    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
    BlobKey blobKey = blobs.get("data");



        if (blobKey != null) {
        resp.getWriter().println(blobKey.getKeyString());
        BlobstoreInputStream in=new BlobstoreInputStream(blobKey);

        byte[] b = IOUtils.toByteArray(in);
        if(b!=null){
            log.log(Level.WARNING,"blobsize: "+b.length);
        }else{
            log.log(Level.WARNING,"b is null");

        }
            in.read(b);
            Asset asset = new Asset(
                    "application/pdf", b, "testfile.pdf");
                Document document = new Document(asset);
                Conversion conversion = new Conversion(document, "image/png");

                ConversionService service =
                    ConversionServiceFactory.getConversionService();
                ConversionResult result = service.convert(conversion);

                if (result.success()) {
                  // Note: in most cases, we will return data all in one asset,
                  // except that we return multiple assets for multi-page images.
                FileService fileService=FileServiceFactory.getFileService(); 
                for (Asset ass : result.getOutputDoc().getAssets()) {
                    AppEngineFile file=fileService.createNewBlobFile("image/png", "test3file.png");
                    FileWriteChannel writeChannel=fileService.openWriteChannel(file, true);
                    writeChannel.write(ByteBuffer.wrap(ass.getData()));

                    writeChannel.closeFinally();
                  }
                } else {
                    log.log(Level.WARNING,"error");

                }