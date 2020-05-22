GetObjectRequest request = new GetObjectRequest(existingBucketName, keyName);
    S3Object object = s3Client.getObject(request);
    S3ObjectInputStream objectContent = object.getObjectContent();
    FileOutputStream fos = new FileOutputStream("/tmp/abc.jar");

    byte[] buffer = new byte[4096];

    int buf = 0;
    while((buf = objectContent.read(buffer)) > 0)
    {
        fos.write(buffer, 0, buf);
    }
    fos.close();