Set<String> validLinks = new HashSet<String>();
Set<String> invalidLinks = new HashSet<String>();

Document document = Jsoup.connect("http://example.com").get();
Elements links = document.select("a");

for (Element link : links) {
    String url = link.absUrl("href");

    if (!validLinks.contains(url) && !invalidLinks.contains(url)) {
        try {
            int statusCode = Jsoup.connect(url).execute().statusCode();

            if (200 <= statusCode && statusCode < 400) {
                validLinks.add(url);
            } else {
                invalidLinks.add(url);
            }
        } catch (Exception e) {
            invalidLinks.add(url);
        }
    }
}