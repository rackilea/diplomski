public String getHTMLFormat() {
    WikiModel wikiModel = new WikiModel(
            "http://en.wikipedia.org/wiki/${image}", "http://en.wikipedia.org/wiki/${title}");
    String htmlText = wikiModel.render(text);
    return htmlText;
}