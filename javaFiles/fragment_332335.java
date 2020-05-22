String html_src = ...

Document doc = Jsoup.parse(html);
Element eMETA = doc.select("META").first();
String content = eMETA.attr("content");
String urlRedirect = content.split(";")[1];
String url = urlRedirect.split("=")[1].replace("'","");