InputStream is = socket.getInputStream();
byte[] data = new byte[92];
for (int pos = 0; pos < data.length; ) {
  int n = is.read(data, pos, data.length - pos);
  if (n < 0)
    throw new EOFException();
  pos += n;
}
/* Print what you read for debugging... */
for (byte b : data)
  System.out.printf("%02X", b & 0xFF);
System.out.println();