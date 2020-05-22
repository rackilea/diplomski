String bucketName = "BUCKET_NAME";
String key = "KEY_OF_OBJECT";

AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(Regions.DEFAULT_REGION)
                    .withCredentials(new ProfileCredentialsProvider())
                    .build();

System.out.println("Downloading an object");
S3Object fullObject = s3Client.getObject(new GetObjectRequest(bucketName, key));
System.out.println("Content-Type: " + fullObject.getObjectMetadata().getContentType());
System.out.println("Content: ");

// fullObject.getObjectContent() is an InputStream 

BufferedReader reader = new BufferedReader(new InputStreamReader(fullObject.getObjectContent()));
String line = null;
while ((line = reader.readLine()) != null) {
    System.out.println(line);
}