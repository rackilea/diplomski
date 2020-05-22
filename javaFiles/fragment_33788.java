String unescapeHtmlCp1252(String input) {
    String nohtml = HtmlUtils.htmlUnescape(input);
    byte[] bytes = nohtml.getBytes(StandardCharsets.ISO_8859_1);
    String result = new String(bytes, Charset.forName("cp1252"));
    return result;
}