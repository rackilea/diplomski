byte[] asciis = number.getBytes(Charset.forName("US-ASCII"));
for (int i =0; i<asciis.length;i++){
   asciis[i] = (byte)(asciis[i]+1);
}
String asciiString = new String(asciis, Charset.forName("US-ASCII"));
String encryptedNumber= StringUtils.reverse(URLEncoder.encode(asciiString, "US-ASCII"));