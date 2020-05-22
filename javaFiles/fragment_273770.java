String z = "public static final ByteOrder BIG_ENDIAN = ByteOrder.BIG_ENDIAN;\nByteOrder order = null;";
Pattern pattern = Pattern.compile("[^ =]+[ ]*=[^=]");
Matcher matcher = pattern.matcher(z);
while (matcher.find()) {
    String match = matcher.group();
    match = match.substring(0, match.length()-2).trim();
    System.out.println(match);
}