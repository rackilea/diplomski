public void getHtml() throws IOException {
    String html = Jsoup
            .connect("http://vp.by/")
            .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_8_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.112 Safari/537.36")
            .get().html();
    System.out.println(html);
}