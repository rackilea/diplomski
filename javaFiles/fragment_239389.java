InputStream is = Context.openFileInput(someFileName);
ByteArrayOutputStream bos = new ByteArrayOutputStream();
byte[] b = new byte[1024];
while ((int bytesRead = is.read(b)) != -1) {
   bos.write(b, 0, bytesRead);
}
byte[] bytes = bos.toByteArray();