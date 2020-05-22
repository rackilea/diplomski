Pattern pattern = Pattern.compile(".*\\.csv");
// 'service' is an instance of S3Service
S3Bucket bucket = service.getBucket(bucketName);
S3Object[] files = service.listObjects(bucket, "processed/files/2015/8", null);
for (int i = 0; i < files.length; i++)
{
    if (pattern.matches(files[i].getKey()))
    {
        // ... work with the file ...
    }
}