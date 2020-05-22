Document doc = Jsoup.connect("http://apod.nasa.gov/apod/archivepix.html").get();
Elements links = content.getElementsByTag("b");
for (Element link : links) {
  String linkHref = link.attr("href");
  String linkText = link.text();
}