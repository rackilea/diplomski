InputStream input = uploadedFile.getInputStream();
ByteArrayOutputStream output = new ByteArrayOutputStream();
// Copy bytes from input to output the usual way.
// ...

byte[] content = output.toByteArray();
// Now store it in session.