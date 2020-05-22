AmazonS3 s3 = new AmazonS3Client();

String bucketName = "bucketName ";
String key = "key.txt";
ObjectMetadata newObjectMetadata = new ObjectMetadata();
// ... whatever you desire, e.g.:
newObjectMetadata.setHeader("Expires", "Thu, 21 Mar 2042 08:16:32 GMT");

CopyObjectRequest copyObjectRequest = new CopyObjectRequest()
                 .WithSourceBucketName(bucketName)
                 .WithSourceKey(key)
                 .WithDestinationBucket(bucketName)
                 .WithDestinationKey(key)
                 .withNewObjectMetadata(newObjectMetadata);

s3.copyObject(copyObjectRequest);