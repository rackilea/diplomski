Pattern pattern = Pattern.compile("<span id=\"artist\">(.*?)<\\/span><span id=\"titl\">(.*?)<\\/span>");
Matcher m = pattern.matcher(input);
if (m.find() {
    MatchResult result = m.toMatchResult();
    String artist = result.group(1);
    String title = result.group(3);
}