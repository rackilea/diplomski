Document doc = Jsoup.parse(
  new File("input.html"), 
  "UTF-8", 
  "http://sample.com/");

Element allSmallSpan = doc.select("span.Allsmall").first(); // Retrive the first <span> element which belongs to "Allsmall" class