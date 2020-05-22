ListVersionsRequest request = new ListVersionsRequest()
                            .withBucketName(bucketName)
                            .withPrefix(bucketKey);

VersionListing versionListing = s3Service.listVersions(request);

List<S3VersionSummary> versionSummaries = versionListing.getVersionSummaries();