private byte[] getByteArrayFromFile(final Document handledDocument) throws IOException {
final ByteArrayOutputStream baos = new ByteArrayOutputStream();
final InputStream in = new FileInputStream(handledDocument);
final byte[] buffer = new byte[500];
int read = -1;
while ((read = in.read(buffer)) > 0) {
    baos.write(buffer, 0, read);
}
in.close();
return baos.toByteArray();
}