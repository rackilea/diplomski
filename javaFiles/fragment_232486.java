// We only want the keys that are in the folder
ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
                                            .withBucketName("my-bucket")
                                            .withPrefix("path/to/folder/");
ObjectListing objectListing;

// Iterate over all the matching keys     
do {
    objectListing = s3client.listObjects(listObjectsRequest);
    for (S3ObjectSummary objectSummary : objectListing.getObjectSummaries())
    {
            // Apply the ACL
            s3.setObjectAcl(bucketName, key, acl);
    }
    listObjectsRequest.setMarker(objectListing.getNextMarker());
} while (objectListing.isTruncated());