final String name = "Grandchamp-le-Ch\\303\\242teau";
final Matcher m = Pattern.compile("\\\\(\\d{3})").matcher(name);
final StringBuffer out = new StringBuffer();
while (m.find()) m.appendReplacement(out, String.valueOf((char)parseInt(m.group(1), 8)));
m.appendTail(out);
final String decoded = new String(out.toString().getBytes(ISO_8859_1), UTF_8);
System.out.println(decoded);