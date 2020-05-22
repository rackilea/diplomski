public static void main(String[] args) {
    String one = "19292";
    String two = "Abc";
    String three = "def";

    System.out.println(surroundWithDoubleQuotes(one, two, three));


}

public static String surroundWithDoubleQuotes(String... input) {
    if(input == null || input.length == 0) {
        return "";
    }
    StringBuilder builder = new StringBuilder();
    for(String arg : input) {
        builder.append("\"\"");
        builder.append(arg);
    }
    builder.append("\"");
    builder.deleteCharAt(0);

    return builder.toString();
}