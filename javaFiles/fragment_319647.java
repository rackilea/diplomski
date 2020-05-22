AmazonS3 s3 = new AmazonS3Client(); // provide credentials, if need be
ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
        .withBucketName("cdn.generalsentiment.com");
for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {
    System.out.println(objectSummary.getKey());
}