Document document = Jsoup
    .connect("http://www.google.com/search?q=" + query)
    .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:5.0) Gecko/20100101 Firefox/5.0")     
    .get();

System.out.println(document.html());