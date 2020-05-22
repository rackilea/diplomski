File file = File.createTempFile(prefix, suffix, "/path/to/uploads");
InputStream input = uploadedFile.getInputStream();
OutputStream output = new FileOutputStream(file);
// Now write input to output.

String uniqueFileName = file.getName();
// Now store filename in DB.