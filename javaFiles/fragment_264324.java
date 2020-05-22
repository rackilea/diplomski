...
is = zipX.getInputStream(zipEntry);
File tmpDir = new File(System.getProperty("java.io.tmpdir"));
//For production, generate a unique name for the temp file instead of using "temp"!
File tempFile = createTempFile("temp", "zip", tmpDir);
this.getFileAsBytes(tempFile.getPath(), name);
break;
...