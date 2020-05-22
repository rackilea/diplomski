String str = "84,104,105,115,32,105,115,32,97,32,116,101,115,116,10";
String[] chars = str.split(",");
byte[] bytes = new byte[chars.length];
for (int i = 0; i < chars.length; i++) {
  bytes[i] = Byte.parseByte(chars[i]);
}
return new String(bytes);