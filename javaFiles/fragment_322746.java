public static void main(String[] args) {
    System.out.println(toTitleCase("first_name"));
    System.out.println(toTitleCase("UPPER_CASE"));
    System.out.println(toTitleCase("ßßß_ßßß_ǆǆǆ"));
}

public static String toTitleCase(String s) {
    StringBuilder sb = new StringBuilder();
    for (String word : s.split("_+")) {
        sb.append(word.substring(0,1).toUpperCase());
        sb.append(word.substring(1).toLowerCase());
    }
    return sb.toString();
}