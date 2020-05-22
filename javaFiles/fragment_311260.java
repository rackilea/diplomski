String output = "";
// Get the webpage and parse it.
Document doc = Jsoup.connect(url).get();
// Get the anchors with href attribute.
// Or, you can use doc.select("a") to get all the anchors. 
Elements links = doc.select("a[href]");
// Iterate over all the links and process them.
for (Element link : links) {
  output += link.attr("abs:href");
}