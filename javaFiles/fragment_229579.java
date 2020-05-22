final byte[] bytes = new byte[1024];
int read = 0;

while ((read = inputStream.read(bytes)) != -1) {
zos.write(bytes, 0, read);
}
zos.close();