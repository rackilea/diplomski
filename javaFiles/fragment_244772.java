String html = ...
Document doc = Jsoup.parse(html);

Element tr = doc.select("tr").first();
Element link = tr.select("a").first();

String dataTitle = tr.attr("data-title");
String href = link.attr("href");