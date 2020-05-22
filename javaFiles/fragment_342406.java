@Test
public void replaceLinks() {
    String regex = "<a href=\".*(foo\\.com|bar\\.org).*\">[^<]+</a>";
    String output = input.replaceAll(regex, "<a href=\"myweb.com\">my web</a>");
    System.out.println(output);
}