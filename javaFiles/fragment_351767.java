List<String> urlList = new ArrayList<>();
    Document doc = Jsoup.connect("https://moz.com/blog-sitemap.xml").get();
    Elements urls = doc.getElementsByTag("loc");

    for (Element url : urls) {
        urlList.add(url.text());
    }