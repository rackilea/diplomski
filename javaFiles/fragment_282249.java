Document doc;
    String str = "";
    try {
        doc = Jsoup.connect(url).get();

        // get all links
        Elements links = doc.select("a[href]");
        for (Element link : links) {
            if(link.text().equals("News")){
                str = RSSLinkRetriever(link.attr("href"));
            }
         }

    } catch (IOException e) {
        e.printStackTrace();
    }
    return str;
}