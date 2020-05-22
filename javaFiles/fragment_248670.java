import java.util.zip.GZIPInputStream;
//your method begins from here
final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();


S3Object object = s3.getObject("your-bucket", "file-path");


return ResponseEntity.ok(IOUtils.toString(new GZIPInputStream(object.getObjectContent())));