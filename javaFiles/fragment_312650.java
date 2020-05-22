public static String fromHex(String s) throws UnsupportedEncodingException {
  byte bs[] = new byte[s.length() / 2];
  for (int i=0; i<s.length(); i+=2) {
    bs[i/2] = (byte) Integer.parseInt(s.substring(i, i+2), 16);
  }
  return new String(bs, "UTF8");
}

fromHex("48656c6c6f2c20576f726c6421"); // => "Hello, World!"