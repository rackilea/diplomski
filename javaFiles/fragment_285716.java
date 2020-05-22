sun.misc.BASE64Encoder encoder= new sun.misc.BASE64Encoder();
byte[] contents = new byte[1024];
int bytesRead = 0;
String strFileContents;
while ((bytesRead = bin.read(contents)) != -1) {
    bout.write(encoder.encode(contents).getBytes());
}