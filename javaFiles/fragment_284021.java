public static void main(String[] args) {
    String str = "(obj.userAge EQUALS  51) AND (obj.userAddress CONTAINS STREET1)";
    Pattern pattern = Pattern.compile("\\((.+?)\\)");
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
        System.out.println(matcher.group(1));
    }

}