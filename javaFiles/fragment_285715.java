byte[] contents = new byte[1024];
int bytesRead = 0;
String strFileContents;
while ((bytesRead = bin.read(contents)) != -1) {
    bout.write(java.util.Base64.getEncoder().encode(contents), bytesRead);
}