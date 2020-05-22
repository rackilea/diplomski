String[] texts = new String[]{"(text text (text) text)",
    "(F(1) = 44)",
    "(text text [text] text)",
    "[text text (text) text]"};
String regex = "\\([a-zA-Z]*\\(\\d+\\)\\s*=\\s*\\d+\\)";

for (String s : texts) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()) {
        System.out.println("There are match " + matcher.group());
    } else {
        System.out.println("No match occurred");
    }
}