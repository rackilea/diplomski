public static String formatJavaCode(String code) throws Exception {
    ASFormatter formatter = new ASFormatter();

    // bug on lib's implementation. reported here: http://barenka.blogspot.com/2009/10/source-code-formatter-library-for-java.html
    code.replace("{", "{\n");

    Reader in = new BufferedReader(new StringReader(code));
    formatter.setJavaStyle();
    in.close();
    return FormatterHelper.format(in,formatter);
}