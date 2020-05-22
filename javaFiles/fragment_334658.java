AmazonS3 s3client = new AmazonS3Client(new PropertiesCredentials(
        S3Sample.class.getResourceAsStream(
                "AwsCredentials.properties")));
try {
    System.out.println("Uploading a new object to S3 from a file\n");
    File file = new File(uploadFileName);
    s3client.putObject(new PutObjectRequest(
                             bucketName, keyName, file));

 } catch (AmazonServiceException ase) {
    System.out.println("Caught an AmazonServiceException, which " +
            "means your request made it " +
            "to Amazon S3, but was rejected with an error response" +
            " for some reason.");
    // ... error handling based on exception details
}