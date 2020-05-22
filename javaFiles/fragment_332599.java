Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
Elements elements = doc.select("a");
for(Element e : elements) {
    if(e.text().contains("banana")) {
        String linkURL = e.attr("abs:href");
    }
}