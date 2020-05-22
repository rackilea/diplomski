try {
    Document doc = Jsoup
            .connect("https://scholar.google.com.pk/scholar?q=Bangla+Speech+Recognition")
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
            .get();

    String title = doc.title();
    System.out.println("title : " + title);

    Elements links = doc.select("div.gs_ggsd").select("a[href]");

    for (Element link : links) {
        System.out.println("\nlink : " + link.attr("href"));
        System.out.println("text : " + link.text());
    }

} catch (IOException e) {
    e.printStackTrace();
}