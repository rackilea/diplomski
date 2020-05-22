S3Object s3object = s3Client.getObject(new GetObjectRequest(bucketName,Path));
    InputStream inContent = s3object.getObjectContent();
    CompressionCodec codec = (CompressionCodec) ReflectionUtils.newInstance(SnappyCodec.class, new Configuration());
    InputStream inStream = codec.createInputStream(new BufferedInputStream(inContent));
    InputStreamReader  inRead = new InputStreamReader(inStream);
    BufferedReader br = new BufferedReader(inRead);
    String line=null;
    while ((line = br.readLine()) != null){
        system.out.println(line);
    }