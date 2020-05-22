public static void main(String[] args) throws IOException {
    AmazonS3 s3client = new AmazonS3Client(new ProfileCredentialsProvider());
    try {
        File file = new File(uploadFileName);
        s3client.putObject(new PutObjectRequest(
                                 bucketName, keyName, file).withCannedAcl(CannedAccessControlList.PublicRead)); // this will set the permission as PublicRead

     } catch (Exception ex) {
        ex.printStacktrace();
    } 
}