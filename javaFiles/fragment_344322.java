// you may need to initialize this differently to get the correct authorization
final AmazonS3Client s3Client = AmazonS3ClientBuilder.defaultClient(); 
final S3Object object = s3Client.getObject("myBucket", "fileToDownload.xlsx");

// with Java 7 NIO
final Path filePath = Paths.get("localFile.xlsx");
Files.copy(object.getObjectContent(), filePath);
final File localFile = filePath.toFile();

// or Apache Commons IO
final File localFile = new File("localFile.xlsx");
FileUtils.copyToFile(object.getObjectContent(), localFile);