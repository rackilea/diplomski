@Override
 public void createFileInCluster(String uriOfFile) throws IOException {
      Validate.notEmpty(uriOfFile);
      FSDataOutputStream out = fileSystem.create(new Path(uriOfFile));
      out.close();
 }