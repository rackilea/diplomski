Document doc = Jsoup.connect("http://www.gsmarena.com/news.php3?iPage=2")
             .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:46.0) Gecko/20100101 Firefox/46.0")
             .get();
        Elements button = doc.select(".pages-next");
        if (!button.isEmpty()) {
            System.out.println("contains");
        } else {
              System.out.println("not contains");
        }