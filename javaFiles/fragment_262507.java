Document document = Jsoup.parse(html);
Elements links = document.select("a.l"); // Select all <a class="l"> elements.

for (Element link : links) {
    System.out.println(link.absUrl("href"));
}