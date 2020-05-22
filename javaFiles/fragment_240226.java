Document doc = Jsoup.connect("http://scholarship-positions.com/category/under-graduate-scholarship/")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")
                    .get();
Elements es = doc.select("article");
for (Element b : es) {
            String title = b.select("a[href], [title]").get(0).text();
            String url = b.select("a[href]").get(0).attr("href");
            String place = b.select("li.custom-fields-ak-organization").get(0).text();
            String content = b.select("section.entry").get(0).text();
            System.out.println(title + url + place + content);
}