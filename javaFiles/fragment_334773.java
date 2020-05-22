String s = ...
Pattern pattern = Pattern.compile("(?i)\\&#((x[A-F0-9]+)|\\d+);");
Matcher m = pattern.matcher(s);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    String code = m.group(1);
    if (code.startsWith("x") || code.startsWith("X")) {
        code = "0" + code;
    }
    int codePoint = Integer.decode(code);
    m.appendReplacement(sb, "");
    sb.appendCodePoint(codePoint);
}
m.appendTail(sb);
s = sb.toString();