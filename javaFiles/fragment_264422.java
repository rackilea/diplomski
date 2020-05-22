@Test
public void testURLMatches() {
    String input = "/path1/path2/123/path3/456";
    Pattern pattern = Pattern.compile("^\\/path1\\/path2\\/([\\w]+)\\/path3\\/([\\w]+)$");
    Matcher matcher = pattern.matcher(input);
    assertTrue(matcher.find());
}