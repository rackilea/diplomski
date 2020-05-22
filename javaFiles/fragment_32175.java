public static void copyObject(AmazonS3 sourceClient, AmazonS3 destClient, String sourceBucket, String sourceKey, String destBucket, String destKey) throws IOException {

    S3ObjectInputStream inStream = null;
    try {
        GetObjectRequest request = new GetObjectRequest(sourceBucket, sourceKey);
        S3Object object = sourceClient.getObject(request);

        inStream = object.getObjectContent();
        destClient.putObject(destBucket,
                destKey, inStream, object.getObjectMetadata());


    } catch (SdkClientException e) {
        throw new ZipException("Unable to copy file.", e);
    } finally {
        if (inStream != null) {
            inStream.close();
        }
    }
}