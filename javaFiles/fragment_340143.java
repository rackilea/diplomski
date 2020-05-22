String decodeNumericEntities(String s) {
    StringBuffer sb = new StringBuffer();
    Matcher m = Pattern.compile("\\&#(\\d+);").matcher(s);
    while (m.find()) {
        int uc = Integer.parseInt(m.group(1));
        m.appendReplacement(sb, "");
        sb.appendCodepoint(uc);
    }
    m.appendTail(sb);
    return sb.toString();
}