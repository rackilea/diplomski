Document doc = Jsoup.connect("http://example.com/").get();
Elements headings = doc.getElementsByTag("h3");
for (Element heading : headings) {
   Element text=heading.nextElementSibling();
   String value=text.text();
}