String input = "IMPU=H\\u’C3A9’tm\\u’C3A9’rf\\u’C3B6’ldescsizma,AC=IMPU,AC=C-NTDB";

StringBuffer buf = new StringBuffer();
Matcher m = Pattern.compile("\\\\u’([0-9A-F]{4}(?:[0-9A-F]{2}){0,2})’").matcher(input);
while (m.find()) {
    byte[] utf8bytes = javax.xml.bind.DatatypeConverter.parseHexBinary(m.group(1));
    m.appendReplacement(buf, new String(utf8bytes, StandardCharsets.UTF_8));
}
String output = m.appendTail(buf).toString();

System.out.println(input);
System.out.println(output);