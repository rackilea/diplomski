public static void main(String[] args) throws Exception {
    final String in = "Review Master:\n"
            + "1111111111\n"
            + "Rating: Fail\n"
            + "Review Master Page";
    final Matcher m = Pattern.compile(""
            + "Review Master:\n"
            + "\\d++\n"
            + "Rating:\\s*+(\\w++)\n"
            + "Review Master Page").matcher(in);
    while(m.find()) {
        System.out.println(m.group(1));
    }
}