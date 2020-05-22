public static void main(String[] args) {
    String quoted = "\"(.*?(?<!\\\\)(?:\\\\\\\\)*)\"";
    Pattern regex = Pattern.compile(
        "(?:^|(?<=,))\\s*(" + quoted + "|[^,]*?)\\s*(?:$|,)");

    String line = "\"Anderson,T\",CWS,\"single quote\\\"\", SS ,,hello,,";
    Matcher m = regex.matcher(line);
    int count = 0;
    while (m.find()) {
        String s = m.group(2) == null ? m.group(1) : m.group(2);
        System.out.println(s);
        count++;
    }
    System.out.printf("(%d matches found)%n", count);
}