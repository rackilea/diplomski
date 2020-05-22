private static final Pattern REGEX_PATTERN = 
        Pattern.compile("[a-z]+n't\\s*", 
                        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);

public static void main(String[] args) {
    String input = "doesn't like\nI don't like\nI don't like having dinner now";

    System.out.println(
        REGEX_PATTERN.matcher(input).replaceAll("not_")
    );
}