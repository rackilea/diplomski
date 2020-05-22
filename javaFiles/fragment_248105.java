public static void main(String[] args) throws Exception {
    final String in = "Some other text\n"
            + "Review Master:\n"
            + "1111111111\n"
            + "Rating: Fail\n"
            + "Review Master Page\n"
            + "Some final text";
    final Matcher m = Pattern.compile(""
            + "\n?"
            + "Review Master:\n"
            + "\\d++\n"
            + "Rating:\\s*+(\\w++)\n"
            + "Review Master Page").matcher(in);
    final StringBuffer output = new StringBuffer();
    while (m.find()) {
        System.out.println(m.group(1));
        m.appendReplacement(output, "");
    }
    m.appendTail(output);
    System.out.println("Result: \"" + output.toString() + "\"");
}