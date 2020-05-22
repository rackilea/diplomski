ObjectListing objectListing = s3.listObjects(new ListObjectsRequest()
                                .withBucketName(bucketName)
                                .withPrefix(""));

for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries()) {s3client.copyObject(sourceBucketName, objectSummary.getKey(), 
                    destinationBucketName, objectSummary.getKey());}