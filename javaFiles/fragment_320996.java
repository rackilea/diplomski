public static void main(String[] args) {
    String html = "<a class=\"sushi-restaurant\" href=\"/greatSushi\">Best Sushi in town</a>";
    Document doc = Jsoup.parse(html, "http://example.com/");
    // find all <a class="sushi-restaurant">...
    Elements links = doc.select("a.sushi-restaurant");
    Element link = links.first();
    // 'abs:' makes "/greatsushi" = "http://example.com/greatsushi":
    String url = link.attr("abs:href");
    System.out.println("url = " + url);
}