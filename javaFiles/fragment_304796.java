AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
    .withRegion("<myRegion>")
    .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
    .enablePathStyleAccess()
    .disableChunkedEncoding()
    .build();