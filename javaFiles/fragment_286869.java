Jets3tProperties props = new Jets3tProperties();
    props.setProperty("s3service.disable-dns-buckets", String.valueOf(true));
    props.setProperty("s3service.s3-endpoint", PB_ENDPOINT);
    props.setProperty("s3service.s3-endpoint-http-port", PB_ENDPOINT_HTTP_PORT);
    props.setProperty("s3service.s3-endpoint-https-port", PB_ENDPOINT_HTTPS_PORT);
    props.setProperty("s3service.https-only", String.valueOf(false));
    AWSCredentials creds = new AWSCredentials(PB_ACCESS_KEY, PB_SECRET_KEY);
    RestS3Service s3Service = new RestS3Service(creds, null, null, props);