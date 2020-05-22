String content = "<h1>title</h1><img src="http://..."></img>";
if(content != null) {
    Document document = Jsoup.parse(content);
    document.select("img").remove();
    content = document.toString();
}