ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
        .withBucketName("mytestbucket20141006")
        .withPrefix("afolder/afolder2/afolder3");
        //.withDelimiter("/");
    ObjectListing objectListing = s3.listObjects(listObjectsRequest);
    for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
        String key = objectSummary.getKey();
        String newKey = key.replace("afolder/afolder2/afolder3/", "afolder3/");
        s3.copyObject("mytestbucket20141006", key, "mytestbucket20141006b",  newKey);
        System.out.println(key);
    }