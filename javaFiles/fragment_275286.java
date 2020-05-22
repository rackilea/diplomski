Connection conn = Jsoup.connect("https://viblo.asia");
Document doc = conn.userAgent("Mozilla").get();

Elements elements = doc.getElementsByClass("post-feed-item"); //This will get the whole element.

for (Element element : elements) {
    String postFeeds = "";

    if (element.toString().contains("docker")) {
        postFeeds = postFeeds.concat(element.toString());  
        //save postFeeds to DB
    }
}