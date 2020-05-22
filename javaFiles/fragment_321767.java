private Path saveAsFile(InputStream stream) throws IOException {
byte[] bytes = new byte[1024];
int readBytes = 0;
ByteArrayOutputStream buffer = new ByteArrayOutputStream();
while ((readBytes = stream.read(bytes)) != -1) {
    buffer.write(bytes, 0, readBytes);
}

//this prints out a longer base64 String than the Javascript part
String base64String = new String(buffer.getBytes, "US-ASCII");
String replaced = base64String.replaceFirst("data:image/png;base64,", "");
byte[] replacedbytes = Base64.decodeBase64(replaced);

Path temp = Files.createTempFile("photo", ".png");
FileOutputStream fos = new FileOutputStream(temp.toFile());
fos.write(replacedbytes);
fos.close();// You should not miss that too! And put it in a "finally" step not to leak file descriptors.
return temp;