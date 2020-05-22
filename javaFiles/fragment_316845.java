final InputStream im = new InputStream() {
      @Override
      public int read() throws IOException {
        return -1;
      }
    };
    final ObjectMetadata om = new ObjectMetadata();
    om.setContentLength(0L);
    PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, im, om);
    s3.putObject(putObjectRequest);