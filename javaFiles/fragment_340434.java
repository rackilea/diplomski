try {
    String userAgent = "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36";
    Document doc = Jsoup.connect("http://htvonline.com.vn/livetv/htv7-hd-34336E61.html").userAgent(userAgent).get();

    String url = doc.select("#play_video").first().attr("data-source");

    System.out.println(url);

} catch (IOException e) {
    e.printStackTrace();
}