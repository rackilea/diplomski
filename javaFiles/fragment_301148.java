private static String foo() {

    String searchTerm = "Pizza";
    String text = "Cheese Pizza, Other Pizzas";

    String sPattern = "(?i)\\b\\w*" + Pattern.quote(searchTerm) + "\\w*\\b";
    StringBuilder result = new StringBuilder("-").append(searchTerm).append(": ");

    Pattern pattern = Pattern.compile(sPattern);
    Matcher matcher = pattern.matcher(text);
    while (matcher.find()) {
        result.append(matcher.group()).append(' ');
    }
    return result.toString().trim();
}