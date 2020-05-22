System.out.println(messageBuffer2.getInt());
byte[] data = new byte[messageBuffer2.limit()];
messageBuffer2.clear();
messageBuffer2.get(data);
String dataString = new String(data, StandardCharsets.ISO_8859_1);
System.out.println(dataString);