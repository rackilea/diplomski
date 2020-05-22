/**
 * @bucketName bucket name (i.e. customer)
 * @path       path within given bucket (i.e. name/firstname)
 * @pattern    pattern that matches required files (i.e. "\\w+\\.gz") 
 */
private List<String> getFileList(String bucketName, String path, Pattern pattern) throws AmazonS3Exception {
    ListObjectsV2Request request = createRequest(bucketName, path);

    return s3.listObjectsV2(request).getObjectSummaries().stream()
                               .map(file -> FilenameUtils.getName(file.getKey()))
                               .filter(fileName -> pattern.matcher(fileName).matches())
                               .sorted()
                               .collect(Collectors.toList());
}

private static ListObjectsV2Request createRequest(String bucketName, String path) {
    ListObjectsV2Request request = new ListObjectsV2Request();
    request.setPrefix(path);
    request.withBucketName(bucketName);
    return request;
}