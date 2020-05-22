public static boolean isValidFile(AmazonS3 s3,
        String bucketName,
        String path) throws AmazonClientException, AmazonServiceException {
    boolean isValidFile = true;
    try {
        ObjectMetadata objectMetadata = s3.getObjectMetadata(bucketName, path);
    } catch (AmazonS3Exception s3e) {
        if (s3e.getStatusCode() == 404) {
        // i.e. 404: NoSuchKey - The specified key does not exist
            isValidFile = false;
        }
        else {
            throw s3e;    // rethrow all S3 exceptions other than 404   
        }
    }

    return isValidFile;
}