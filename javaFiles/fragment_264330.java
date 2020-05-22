public List<String> listKeysInDirectory(String bucketName, String prefix) {
    String delimiter = "/";
    if (!prefix.endsWith(delimiter)) {
        prefix += delimiter;
    }

    ListObjectsRequest listObjectsRequest = new ListObjectsRequest()
            .withBucketName(bucketName).withPrefix(prefix)
            .withDelimiter(delimiter);
    ObjectListing objects = _client.listObjects(listObjectsRequest);
    return objects.getCommonPrefixes();
}