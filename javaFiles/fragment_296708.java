Pattern pattern = Pattern.compile("(\\w+):(\\[(\\*|\\d{4}):\\*\\])");
Matcher matcher = pattern.matcher(text);
if (matcher.matches()) {
    for (int i = 0; i < matcher.groupCount() + 1; i++) {
        System.out.println(i + ":" + matcher.group(i));
    }
} else {
    System.out.println("no match");
}