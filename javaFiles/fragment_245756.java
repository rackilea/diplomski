Document doc = Jsoup.connect("http://www.blah.com/foo.html");
for (Element e : doc.select("img")) {
    String imageSrc = e.attr("src");
    if (imageSrc.contains("/medium/")) {
     ...
    }
}