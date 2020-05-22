byte[] thedigest = md.digest(three);
StringBuilder buff = new StringBuilder();
for (byte b : theDigest) {
  String conversion = Integer.toString(b & 0xFF,16);
  while (conversion.length() < 2) {
    conversion = "0" + conversion;
  }
  buff.append(conversion);
}
String str1 = buff.toString();
System.err.println(str1);