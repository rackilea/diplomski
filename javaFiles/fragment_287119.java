Element result = Jsoup.parse("<html><body><table><tr><td><a href=\"http://a.com\" /</td><td>Label1</td></tr><tr><td><a href=\"http://b.com\" /></td><td>Label2</td></tr></table></body></html>");

for (Element element : result.select("tr")) {
    if (element.select("tr.header.left").isEmpty()) {

        Elements tds = element.select("td");

        String link = tds.get(0).getElementsByTag("a").attr("href");
        String position = tds.get(1).text();

        System.out.println(link + ", " + position);
    }
}