public ExampleClass() {
  try {
      fileInputStreamMethod(DEFAULT_FILE);
  }
  catch(Exception e) {
    ...
  }

public ExampleClass(String fileName) throws Exception {
    fileInputStreamMethod(fileName);
}

private void fileInputStreamMethod(String fileName) throws Exception {
    // your file handling methods
}