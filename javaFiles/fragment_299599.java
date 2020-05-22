inputStream = s.getInputStream();
DataInputStream dis = new DataInputStream(inputStream);
byte[] bytes;
int len;

len = dis.readInt();
bytes = new byte[len];
dis.readFully(bytes);
String username = new String(bytes, StandardCharsets.UTF_8);

len = dis.readInt();
bytes = new byte[len];
dis.readFully(bytes);
String password = new String(bytes, StandardCharsets.UTF_8);