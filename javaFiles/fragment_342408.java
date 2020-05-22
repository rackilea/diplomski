@Test
public void replaceLinksJSoup() {
    Document doc = Jsoup.parse(input);
    Elements links = doc.getElementsByTag("a");
    Pattern pattern = Pattern.compile(".*(foo\\.com|bar\\.org).*");
    for (Element link : links) {
        String linkHref = link.attr("href");
        if (pattern.matcher(linkHref).matches()) {
            link.attr("href", "myweb.com");
            link.text("my web");
        }
    }
    System.out.println(doc.body().html());
}