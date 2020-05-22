Charset iso8859_15 = Charset.forName("ISO-8859-15");
byte[] data = new byte[256];
for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
  data[i - Byte.MIN_VALUE] = (byte) i;
}
String asString = new String(data, iso8859_15);
byte[] encoded = asString.getBytes(iso8859_15);
System.out.println(Arrays.equals(data, encoded));