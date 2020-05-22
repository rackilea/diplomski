ClientConfiguration cc = new ClientConfiguration()
    .withMaxErrorRetry (10)
    .withConnectionTimeout (10_000)
    .withSocketTimeout (10_000)
    .withTcpKeepAlive (true);
AmazonS3 s3Client = new AmazonS3Client (credentials, cc);