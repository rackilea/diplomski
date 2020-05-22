public static void main(String[] args) {
    String str = "aebci";
    Pattern pattern = Pattern.compile("([aeiou][^aeiou])|([^aeiou][aeiou])");
    Matcher matcher = pattern.matcher(str);

    StringBuffer buffer = new StringBuffer();
    while (matcher.find()) {
        String group = matcher.group(); // two symbols
        matcher.appendReplacement(buffer, group.charAt(0) + " " + group.charAt(1));
    }
    matcher.appendTail(buffer);
    System.out.println(buffer.toString());
}