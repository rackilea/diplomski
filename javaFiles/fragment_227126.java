//Define InputStreams to read from the URLConnection.
InputStream is = ucon.getInputStream();
BufferedInputStream bis = new BufferedInputStream(is);

//I usually use a ByteArrayOutputStream, as it is more common.
ByteArrayOutputStream baos = new ByteArrayOutputStream();
int red = 0;
// This size can be changed
byte[] buf = new byte[1024];
while ((red = bis.read(buf)) != -1) {
    baos.write(buf, 0, red);
}