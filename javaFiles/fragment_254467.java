public void countMatches() {
    String[] A = {"hello", "you"};
    String s = "hello, hello you are so wonderful";
    String patternString = "(" + StringUtils.join(A, "|")   + ")";
    Pattern pattern = Pattern.compile(patternString);
    Matcher matcher = pattern.matcher(s);
    int count = 0;
    while (matcher.find()) {
        count++;
    }
    System.out.println(count);
}