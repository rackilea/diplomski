public static void main(String[] args) throws IOException {
            // collect the html and create the doc
    String url = "http://finance.yahoo.com/q?s=goog";
    Document doc = Jsoup.connect(url).get();

            // locate the header, title and then found the h2 tag
    Element header = doc.select("div[id=yfi_rt_quote_summary]").get(0);
    Element title = header.select("div[class=title]").get(0);
    String h2 = title.select("h2").get(0).text();

            // split by open parenthesis (double escape) and strip off the close parenthesis
            // TODO - regular expression help handle situation where exist multiple "()"s
    String[] parts = h2.split("\\(");
    String name = parts[0];
    String shortname = parts[1].replace(")", "");
    System.out.println(name);
    System.out.println(shortname);

}