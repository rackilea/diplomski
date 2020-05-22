Document doc = Jsoup.connect("your-url").get()
// select all "div" elements with a class name "main_news_lp_img3"
for (Element el : doc.select("div.main_news_lp_img3")) {
    // get the "style" attribute value
    String style = el.attr("style");
    // parse the url from the attribute
    String url = StringUtils.substringBetween(style, "background-image: url('", "')");
    // do something with url...
}