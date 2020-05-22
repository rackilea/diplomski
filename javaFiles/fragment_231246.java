InputStream sis = sock.getInputStream();
ByteArrayOutputStream baos = new ByteArrayOutputStream();
while (int len = sis.read(bytes) > 0) {
    baos.write(bytes, 0, len);
}
ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
DataInputStream dis = new DataInputStream(bais);
byte[] vBytes = new byte[baos.size()];
int sLen = dis.read(vBytes);
String receivedMessage = new String(vBytes, 0, sLen);
System.out.println("Message received: " + receivedMessage);