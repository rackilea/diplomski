public static void main(String[] args) {
    String source = "<html>blah<code>this is awesome</code>more junk</html>";

    String startDelim = "<code>";
    String endDelim = "</code>";
    int start = source.indexOf(startDelim);
    int end = source.indexOf(endDelim);

    String code = source.substring(start + startDelim.length(), end);
    System.out.println(code);
}