doc = Jsoup.connect("http://google.com").get();

 Elements links = doc.select("a[href]");
    for (Element link : links) {

        System.out.println("\nlink : " + link.attr("href"));
        System.out.println("text : " + link.text());